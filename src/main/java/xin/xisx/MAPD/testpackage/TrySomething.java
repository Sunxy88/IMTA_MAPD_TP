package xin.xisx.MAPD.testpackage;

public class TrySomething {
    public static void main(String[] args) throws Exception {
        Father obj = new Son();
        obj.method1();
    }
}

class Father {
    protected int age = 0;
    public void method1() throws Exception {
        System.out.println(age);
        System.out.println("Throw Exception...");
    }
}

/**
 * To test exception in inherit. We can throw a more specific exception in subclass.
 */
class Son extends Father {
    private int age = 1;
    public void method1() throws RuntimeException {
        System.out.println(age);
        System.out.println(super.age);
        System.out.println("Throw RuntimeException..");
    }
}