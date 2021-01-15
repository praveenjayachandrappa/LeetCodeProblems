package inheritance;

public class OverloadingCalculation3 {

    public void sum(int a,long b){
        System.out.println("a method invoked");
    }
    public void sum(long a,long b){
        System.out.println("b method invoked");
    }

    public static void main(String[] args) {
        OverloadingCalculation3 overloadingCalculation3=new OverloadingCalculation3();
        overloadingCalculation3.sum(10,10);
    }
}
