package jvm;

/**
 * @author: subiin
 * @date: 2018/1/20 下午5:03
 * @description:
 */
public class StringInternDemo {
    public static void main(String[] args) {
        String s = new String("11");

        s.intern();

        String s2 = "11";
        System.out.println(s2 == s);

        String s3 = "2" + new String("3");
        s3.intern();
        String s4 = "23";
        System.out.println(s3 == s4);

    }
}
