public class IsPowerofFour {


    public static boolean isPowerofFour(int n){
    /*    if(n==0) return false;

        while (n!=1 && n!=-1){
            if(n%4!=0) return false;
            n=n/4;
        }
        return true;
    */
    return ((n & n-1)==0) && n%3==1;
    }

    public static void main(String[] args) {
        int n=256;
        boolean powerofFour = isPowerofFour(n);
        System.out.println(powerofFour);
    }
}
