package cn.simple.test.new_features.jdk9.jir;

/**
 * exports jdk.internal.reflect to java.sql, jdk.dynalink, java.logging, java.sql.rowset, jdk.unsupported, jdk.scripting.nashorn;
 * <p>
 * Created by zengxf on 2017/10/10.
 */
@Deprecated(forRemoval = true)
public class TestReflection {

    public static void main(String[] arr) {
        test1();
    }

    static void test1() {
        test2();
    }

    static void test2() {
        Test.test();
    }

    static class Test {
        static void test() {
            TestB.test();
        }
    }

    static class TestB {
        static void test() {
            System.out.println("==================");
//            System.out.println(Reflection.getCallerClass());
        }
    }

}
