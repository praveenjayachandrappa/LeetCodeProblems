/*package inheritance;

public class MainDemo {

    public static void main(String[] args) {

     *//*   A a=new B();
        a.printData();
        a.display();
        B b2=new B();
        b2.display();
 *//**//*
    A a=new A();
    a.method1();
    a.method1(20);

    B b=new B();
    b.method1();
   b.method1(10);*//*
*//*
        System.out.println("Dynamic method dispatch ");
        A a2=new B();
        a2.method1(10.78);
        a2.method1(45);
    }*//*
}

class A{

    public void method1(){
        System.out.println("parent class method no argumetns");
    }
    public void  method1(int a){
        System.out.println("parent class method one argumetns");
    }
    public void  method1(double a){
        System.out.println("parent class method DOUBLE argumetns");
    }
   static public void display(){
       System.out.println("parent static method from the super class");
   }
    protected void printData(){
        System.out.println("A class method ");
    }
}
class B {

    @Override
    public void method1(int x){
        System.out.println("child class method with one argument");
    }


    *//*static public void display(){
        System.out.println("child class static method ..");
    }*//*
    @Override
    public void printData(){
        System.out.println("the printMethod from the subclass");
    }
}*/
