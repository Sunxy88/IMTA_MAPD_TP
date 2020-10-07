package xin.xisx.MAPD.testpackage;

public class TrySomething {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inneer = outer.newInnerClass();
        outer.say();
        inneer.say();
    }
}

class Outer {
    class Inner {
        public void say() {
            System.out.println("Inner class...");
        }
    }

    public void say() {
        System.out.println("Outer class...");
    }

    public Inner newInnerClass() {
        return new Inner();
    }
}