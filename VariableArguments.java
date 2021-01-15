public class VariableArguments {

                                //formal parameter passing
    public static void parameterPassing(int x){
        x++;
        System.out.println(x);
    }

    public static void parameterPassing(StringBuilder str){
        str=str.append("-ASHA");
        System.out.println(str);
    }

    public static boolean isPrime(int num){

        for (int i = 2; i <=num/2 ; i++) {
            if (num%i==0) return false;
        }
        return true;
    }

    public static void getObject(Object ...objects){

        for (Object o:
             objects) {
            System.out.println(o.toString());
        }
    }

    public static void printNumbers(int ...nums){

        for (int x:nums) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*printNumbers();
        printNumbers(10);
        printNumbers(1,2,3,4,7,8,9,11,12,33,12);
        System.out.println("using array I am passing variable number arguments");
        printNumbers(new int[]{21,13,35,65,333,22,234,4,4,455});

        */

/*        getObject(new String("asha"),new StringBuffer("praveen"),new StringBuilder("andy"),new Integer(10),new Long(5857575l));*/
/*

        System.out.println(isPrime(9)); //false
        System.out.println(isPrime(11)); //true
        System.out.println(isPrime(2)); //true
        System.out.println(isPrime(3)); //true
        System.out.println(isPrime(21)); //false
    */
                int x=10;
                parameterPassing(x);  //actual parameter  passing
        System.out.println(x);
        StringBuilder stringBuilder=new StringBuilder("PRAVEEN");
        parameterPassing(stringBuilder); //pass by reference
        System.out.println(stringBuilder);
        }
}
