package math;

public class HappyNumber {
    public boolean isHappy(int n) {

        int copyN=n;

        if(n<1)
            return false;

        int newN=0;
        while(n>3){
            newN=0;
            while(n>0){
                int p=n%10;
                newN+=p*p;
                n=n/10;
            }
            if(newN==copyN || newN==4)
                return false;
            n=newN;
        }

        return n==1?true:false;

    }

    public static void main(String[] args) {

        int n=19;
        HappyNumber happyNumber=new HappyNumber();
        boolean happy = happyNumber.isHappy(n);
        System.out.println(happy);
    }
}
