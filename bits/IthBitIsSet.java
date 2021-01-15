package bits;

public class IthBitIsSet {

    public static int setIthBit(int num, int k) {
        /*int f = 1;
        f = f << i;
        num = num | f;
        return num;*/
        // kth bit of n is being set by this operation
        return ((1 << k) | num); //merging
    }

    public static boolean checkIthBitSet(int num, int i) {

        int f = 1;
        f = f << i;
        return (num & f) > 0 ? true : false; //masking

    }

    public static void main(String[] args) {
    /*    int n=12;
        int i=2;
        System.out.println(checkIthBitSet(n,i));
    */
    /*int n=5;
    n=n>>;
        System.out.println(n);
    }*/
        int n = 10;
        int i = 2;
        int newNum = setIthBit(n, i);
        System.out.println(newNum);
    }
}