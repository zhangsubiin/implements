package com.subin.framework.springmvc.framework.servlet;

import com.subin.framework.springmvc.framework.annotation.EMController;
import com.subin.framework.springmvc.framework.annotation.EMRequestMapping;
import com.subin.framework.springmvc.framework.annotation.EMRequestParam;
import com.subin.framework.springmvc.framework.context.EMApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: subiin
 * @date: 2018/2/24 下午10:13
 * @description:
 */
public class EMDispatcherServlet extends HttpServlet {

    private static final String LOCATION = "contextConfigLocation";

//    private Map<String, Handler> handlerMapping = new HashMap<String, Handler>();

//    private Map<Pattern, Handler> handlerMapping = new HashMap<Pattern, Handler>();

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    private Map<Handler, HandlerApapter> adapaterMapping = new HashMap<Handler, HandlerApapter>();

    private List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();

    @Override
    public void init(ServletConfig config) throws ServletException {

        //必须先初始化 IOC 容器
        EMApplicationContext context = new EMApplicationContext(config.getInitParameter(LOCATION));

        Map<String, Object> ioc = context.getAll();

        System.out.println(ioc);
        System.out.println(ioc.get("firstController"));

        //请求解析
        initMultipartResolver(context);
        //多语言、国际化
        initLocaleResolver(context);
        //主题View层的
        initThemeResolver(context);

        //=========== 重要 =========
        //解析url和Method的关联关系
        initHandlerMappings(context);
        //适配器（匹配的过程）
        initHandlerAdapters(context);
        //=========== 重要 =========

        //异常解析
        initHandlerExceptionResolvers(context);
        //视图转发（根据视图名字匹配到一个具体模板）
        initRequestToViewNameTranslator(context);

        //解析模板中的内容（拿到服务器传过来的数据，生成HTML代码）
        initViewResolvers(context);

        initFlashMapManager(context);

        System.out.println("EMSpring MVC is init.");
    }

    /**
     * 请求解析
     * @param context
     */
    private void initMultipartResolver(EMApplicationContext context){}

    /**
     * 多语言、国际化
     * @param context
     */
    private void initLocaleResolver(EMApplicationContext context){}

    /**
     * 主题View层的
     * @param context
     */
    private void initThemeResolver(EMApplicationContext context){}

    /**
     * 解析url和Method的关联关系
     * @param context
     */
    private void initHandlerMappings(EMApplicationContext context){
        Map<String, Object> ioc = context.getAll();
        if (ioc.isEmpty()) {
            return;
        }

        //只要是由Cotroller修饰类，里面方法全部找出来
        //而且这个方法上应该要加了RequestMaping注解，如果没加这个注解，这个方法是不能被外界来访问的
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {

            Class<?> clazz = entry.getValue().getClass();

            if (!clazz.isAnnotationPresent(EMController.class)) {
                continue;
            }

            String url = "";

            if (clazz.isAnnotationPresent(EMRequestMapping.class)) {
                EMRequestMapping requestMapping = clazz.getAnnotation(EMRequestMapping.class);
                url = requestMapping.value();
            }

            //扫描Controller下面的所有方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(EMRequestMapping.class)) {
                    continue;
                }
                EMRequestMapping requestMapping = method.getAnnotation(EMRequestMapping.class);
//                String mappingUrl = url + requestMapping.value();
                //Spring 中的经典，HandlerMapping 的正则匹配

                String regex = (url + requestMapping.value()).replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regex);

//                handlerMapping.put(pattern, new Handler(entry.getValue(), method));

                handlerMapping.add(new Handler(entry.getValue(), method, pattern));

//                System.out.println("Mapping: " + mappingUrl + " " + method.toString());

                System.out.println("Mapping: " + regex + " " + method.toString());
            }

        }

        //RequestMapping 会配置一个url，那么一个url就对应一个方法，并将这个关系保存到Map中
    }

    /**
     * 适配器（匹配的过程）,主要是用来动态匹配我们参数的
     * @param context
     */
    private void initHandlerAdapters(EMApplicationContext context){

        if (handlerMapping.isEmpty()) {
            return;
        }

        //参数类型作为key，参数的索引号作为值
        Map<String, Integer> paramMapping = null;

//        for (Map.Entry<Pattern, Handler> entry : handlerMapping.entrySet()) {
        for (Handler handler : handlerMapping) {
            paramMapping = new HashMap<String, Integer>();

            //把这个方法上面所有的参数全部获取到
            Class<?>[] parameterTypes = handler.method.getParameterTypes();

            //有顺序，但是通过反射，没法拿到我们参数名字
            //因为每个参数上面是可以加多个数组的，所以是二维数组,第一位表示参数位置，第二位表示注解个数
            Annotation[][] pa = handler.method.getParameterAnnotations();
            //匹配自定参数列表
            for (int i = 0; i < pa.length; i++) {
                Class<?> type = parameterTypes[i];

                if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                    paramMapping.put(type.getName(), i);
                    continue;
                }

                for (Annotation annotation : pa[i]) {
                    if (annotation instanceof EMRequestParam) {
                        String paramName = ((EMRequestParam) annotation).value();
                        if (!"".equals(paramName.trim())) {
                            paramMapping.put(paramName, i);
                        }
                    }
                }
            }

            adapaterMapping.put(handler, new HandlerApapter(paramMapping));

        }

    }

    /**
     * 异常解析
     * @param context
     */
    private void initHandlerExceptionResolvers(EMApplicationContext context){}

    /**
     * 视图转发（根据视图名字匹配到一个具体模板）
     * @param context
     */
    private void initRequestToViewNameTranslator(EMApplicationContext context){}

    /**
     * 解析模板中的内容（拿到服务器传过来的数据，生成HTML代码）
     * @param context
     */
    private void initViewResolvers(EMApplicationContext context){

        //模板一般是不会放到WebRoot下的，而是放在WEB-INF下，或者classes下
        //这样就避免了用户直接请求到模板
        //加载模板的个数，存储到缓存中
        //检查模板中的语法错误

        String templateRoot = context.getConfig().getProperty("templateRoot");

        //归根到底就是一个文件，普通文件
        String rootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File rootDir = new File(rootPath);
        for (File template : rootDir.listFiles()) {
            viewResolvers.add(new ViewResolver(template.getName(), template));
        }

    }

    private void initFlashMapManager(EMApplicationContext context){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    //在这里调用自己写的Controller的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用");
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500 Exception, Msg :" + Arrays.toString(e.getStackTrace()));
        }
    }

    private Handler getHandler(HttpServletRequest request) {
        //循环handlerMapping
        if (handlerMapping.isEmpty()) {
            return null;
        }

        String url = request.getRequestURI();
        String contextPath = request.getContextPath();

        url = url.replace(contextPath, "").replaceAll("/+", "/");

//        return handlerMapping.get(url);

        //Spring HandlerMapping 的经典正则匹配
//        for (Map.Entry<Pattern, Handler> entry : handlerMapping.entrySet()) {
        for (Handler handler : handlerMapping) {

            Matcher matcher = handler.pattern.matcher(url);

            if (!matcher.matches()) {
                continue;
            }

            return handler;
        }

        return null;
    }

    private HandlerApapter getHandlerAdapter(Handler handler) {
        if (adapaterMapping.isEmpty()) {
            return null;
        }

        return adapaterMapping.get(handler);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception{

        //先取出来一个 Handler， 从 HandlerMapping 中取
        Handler handler = getHandler(request);
        if (handler == null) {
            response.getWriter().write("404 Not Found");
        }

        //再取出来一个适配器
        HandlerApapter ha = getHandlerAdapter(handler);


        if (ha != null) {
            //再由适配器调用具体方法
            EModelAndView mv = ha.handle(request, response, handler);
            applyDefaultViewName(response, mv);
        }



    }

    public void applyDefaultViewName(HttpServletResponse response, EModelAndView mv) throws Exception {
        if (null == mv) {
            return;
        }

        if (viewResolvers.isEmpty()) {
            return;
        }

        for (ViewResolver viewResolver : viewResolvers) {
            if (!mv.getView().equals(viewResolver.getViewName())) {
                continue;
            }

            String r = viewResolver.parse(mv);

            if (r != null) {
                response.getWriter().write(r);
                break;
            }
        }
    }

    /**
     * HandlerMapping 定义
     */
    private class Handler {

        protected Object controller;
        protected Method method;
        protected Pattern pattern;

        public Handler(Object controller, Method method, Pattern pattern) {
            this.controller = controller;
            this.method = method;
            this.pattern = pattern;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Handler handler = (Handler) o;
            return Objects.equals(controller, handler.controller) &&
                    Objects.equals(method, handler.method) &&
                    Objects.equals(pattern, handler.pattern);
        }

        @Override
        public int hashCode() {

            return Objects.hash(controller, method, pattern);
        }
    }

    /**
     * 方法适配器
     */
    private class HandlerApapter {

        private Map<String, Integer> paramMapping;

        public HandlerApapter(Map<String, Integer> paramMapping) {
            this.paramMapping = paramMapping;
        }

        /**
         * 主要目的是用反射调用url对应的method
         * @param request
         * @param response
         * @param handler
         */
        public EModelAndView handle(HttpServletRequest request, HttpServletResponse response, Handler handler) throws InvocationTargetException, IllegalAccessException {

            //为什么要传req、为什么要穿resp、为什么传handler
            //为了给request、response赋值
            Class<?>[] parameterTypes = handler.method.getParameterTypes();

            //要想给参数赋值，只能通过索引号来找到具体的某个参数
            Object[] paramValues = new Object[parameterTypes.length];

            Map<String, String[]> params = request.getParameterMap();

            for (Map.Entry<String, String[]> param : params.entrySet()) {
                String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "")
                        .replaceAll(",\\s", ",");

                if (!this.paramMapping.containsKey(param.getKey())) {
                    continue;
                }

                Integer index = this.paramMapping.get(param.getKey());

                //单个赋值是不行的
                paramValues[index] = caseStringValue(value, parameterTypes[index]);
            }

            //request 和 response 要赋值
            String requestName = HttpServletRequest.class.getName();
            if (this.paramMapping.containsKey(requestName)) {
                Integer requestIndex = this.paramMapping.get(requestName);
                paramValues[requestIndex] = request;
            }
            String responseName = HttpServletResponse.class.getName();
            if (this.paramMapping.containsKey(responseName)) {
                Integer responseIndex = this.paramMapping.get(responseName);
                paramValues[responseIndex] = response;
            }

            boolean isModelAndView = handler.method.getReturnType() == EModelAndView.class;
            Object r = handler.method.invoke(handler.controller, paramValues);
            if (isModelAndView) {
                return (EModelAndView) r;
            } else {
                return null;
            }

        }

        /**
         * 转换参数类型
         * @param value
         * @param clazz
         * @return
         */
        private Object caseStringValue(String value, Class<?> clazz) {
            if (clazz == String.class) {
                return value;
            } else if (clazz == Integer.class) {
                return Integer.valueOf(value);
            } else if (clazz == int.class) {
                return Integer.valueOf(value);
            } else {
                return null;
            }
        }

    }

    private class ViewResolver {
        private String viewName;
        private File file;

        // 在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。
        // 说明：不要在方法体内定义：Pattern pattern = Pattern.compile(规则);
        //    public class XxxClass {
        //        // Use precompile
        //        private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
        //        public Pattern getNumberPattern() {
        //            // Avoid use Pattern.compile in method body.
        //            Pattern localPattern = Pattern.compile("[0-9]+");
        //            return localPattern;
        //        }
        //    }
        private Pattern pattern = Pattern.compile("@\\{(.+?)}", Pattern.CASE_INSENSITIVE);

        protected ViewResolver(String viewName, File file) {
            this.viewName = viewName;
            this.file = file;
        }

        protected String parse(EModelAndView mv) throws Exception {

            StringBuffer sb = new StringBuffer();

            RandomAccessFile ra = new RandomAccessFile(this.file, "r");

            try {
                //模板框架的语法是非常复杂，但是，原理是一样的
                //无非都是用正则表达式来处理字符串而已
                String line = null;
                while (null != (line = ra.readLine())) {
                    Matcher matcher = matcher(line);
                    while (matcher.find()) {
                        for (int i = 1; i <= matcher.groupCount(); i++) {
                            String paramName = matcher.group(i);
                            Object paramValue = mv.getModel().get(paramName);
                            if (null == paramValue) {
                                continue;
                            }
                            line = line.replaceAll("@\\{" + paramName + "}", paramValue.toString());
                        }
                    }

                    sb.append(line);
                }
            } finally {
                ra.close();
            }

            return sb.toString();
        }

        private Matcher matcher(String str) {
            return pattern.matcher(str);
        }

        public String getViewName() {
            return viewName;
        }
    }



}
