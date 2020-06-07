package com.runoob;

public class TestString {
    public static void main(String[] args) {
        TestString str = new TestString();
        str.test();
//        Test1 te = new Test1();
//        System.out.println(te.toString()+","+te.hashCode());
    }

    // 字符串广泛应用 在 Java 编程中，在 Java 中字符串属于对象，Java 提供了 String 类来创建和操作字符串。
    public void test() {
        String greet = "菜鸟教程";
        String greet1 = "菜鸟教程";
        int len = greet.length();
        System.out.println(greet.hashCode());

        String ss = new String("菜鸟教程");
        String sss = new String("菜鸟教程");
        System.out.println(greet == ss);
        System.out.println(greet.equals(ss));

        System.out.println(greet1 == greet );
        System.out.println(greet1.equals(greet));

        System.out.println(ss == sss);
        System.out.println(ss.equals(sss));
    }

}

class Test1{
    int id;
}