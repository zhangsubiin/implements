package jvm;

/**
 * @author: subiin
 * @date: 2018/1/20 下午3:21
 * @description:
 */
public class JVMDemoTest {
    /**
     * 获取当前JVM的内存信息
     * @return
     */
    public static String toMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        int freeMemory = (int) (runtime.freeMemory() / 1024 / 1024);
        int totalMemroy = (int) (runtime.totalMemory() / 1024 / 1024);
        return freeMemory + "M/" + totalMemroy + "M(free/total)";
    }

    public static void main(String[] args) {
        System.out.println("memory info :" + toMemoryInfo());
    }
}
