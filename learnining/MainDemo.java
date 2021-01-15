/*
package learnining;

import com.sun.org.apache.xml.internal.utils.QName;
import inheritance.Parent;

final class  A{
    final public static String name="praveen";
    public final void method1(){
        System.out.println("Parent class method1");
    }
    public void method2_parent(){
        System.out.println("Parent class Method 2");
    }
    public static void method3_static(){
        System.out.println("Static method from the parent class");
    }
    public  final void method4_final(){
        System.out.println("Final method of parent class");
    }
}

class B extends A{

    @Override
    public  void method1() {
        System.out.println("Child class method1");
    }

    public void method2(){
        System.out.println("Child class method2 ");
    }
    */
/*public static void method3_static(){
        System.out.println("Static method from the Child class");
    }*//*

}


public class MainDemo {
    public static void main(String[] args) {
        */
/*A a=new B(); //Parent class reference pointing to child class object
        a.method3_static();
        B b=new B();
        b.method3_static();
        b.method4_final();
        System.out.println(b.name);

        *//*


        A a=new B();
        a.method3_static();

        B b=new B();
        b.method3_static();

    }
}
*/
/*


class A{
    final String name;
    //Final is used

}
*/

package learnining;
public class MainDemo{

    public void add(int a,long b){
        System.out.println("a method");
    }
    public void add(long a,byte b){
        System.out.println("B method");
    }



    public static void main(String[] args) {
        MainDemo obj=new MainDemo();
        short a=1;
        byte b=2;
        //obj.add(a,b);
    }
}
