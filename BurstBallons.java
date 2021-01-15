import java.awt.image.ImageProducer;

public class BurstBallons {


    public static int maxCoins(int[] nums) {

        int n=nums.length+2;
        int[] A=new int[n];
        A[0]=A[n-1]=1;
        for (int i = 0; i < nums.length; i++) {
            A[i+1]=nums[i];
        }

        return getCoin(A,0,n-1);
    }

    private static int getCoin(int[] a, int left, int right) {

        int max=0;

        for (int i = left+1; i < right; i++) {

            int score=a[left]*a[i]*a[right];
            max=Math.max(max,score+getCoin(a,left,i)+getCoin(a,i,right));
        }
        return max;
    }


    public static void main(String[] args) {

        int[] nums={3,1,5,8};

        int res = maxCoins(nums);

        System.out.println(res);

    }

}
