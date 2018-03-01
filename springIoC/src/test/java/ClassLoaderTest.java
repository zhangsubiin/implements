import sun.misc.Launcher;

import java.net.URL;

/**
 * @author: subiin
 * @date: 2018/1/15 下午10:27
 * @description:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
        System.out.println("------------");
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
