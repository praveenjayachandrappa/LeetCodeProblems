public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
       /* if(n<1)
            return false;
        if(n==1)
            return true;
        while(n%3==0){
            n/=3;
        }
        return n==1;
        */

        return (Math.log10(n)/Math.log10(3))%1==0;
    }


    public static void main(String[] args) {
/*

        int x=3;

        int sqrt =(int) Math.sqrt(16);
        System.out.println(sqrt);
*/

        boolean powerOfThree = isPowerOfThree(27);
        System.out.println(powerOfThree);

    }
}
