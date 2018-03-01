import com.subin.framework.ioc.core.JsonApplicationContext;
import com.subin.framework.ioc.entity.Robot;

/**
 * @author: subiin
 * @date: 2018/1/14 下午12:02
 * @description:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot aiRobot = (Robot) applicationContext.getBean("robot");
        aiRobot.show();
    }
}
