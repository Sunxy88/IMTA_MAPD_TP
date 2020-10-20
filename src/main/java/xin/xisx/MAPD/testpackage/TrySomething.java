package xin.xisx.MAPD.testpackage;

public class TrySomething {
    public static void main(String[] args) {
        Son son = new Son();
        son.say();
    }
}


class Father {
    public void say() {
        System.out.println("Father");
    }
}

class Son extends Father {}