package inheritance;

public class Parent {

    private void method1(){
        System.out.println("Method 1 of Parent class ");
    }

    protected void method2(){
        System.out.println("Protected method of parent class");
        this.method1();
    }
    public static void method3(){
        System.out.println("Static method of Parent class");
    }
}
