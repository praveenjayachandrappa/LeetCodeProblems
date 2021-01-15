package inheritance;

public class Child extends Parent {


    private void method1(){
        System.out.println("Method 1 of Child class ");

    }

    @Override
    protected void method2() {
       this.method1();
    }

    public static void method3(){
        System.out.println("Static method of Child class");
    }
}
