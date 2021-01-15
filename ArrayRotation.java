import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayRotation {
        public static void rotate(int[] nums, int k) {
            // speed up the rotation
            k %= nums.length;
            int temp, previous;
            for (int i = 0; i < k; i++) {
                previous = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = previous;
                    previous = temp;
                }
                System.out.println(Arrays.toString(nums));
            }

            System.out.println(Arrays.toString(nums));
        }

    public static void rotate2(int[] nums, int k) {
       int n=nums.length;
        int[] rotate=new int[n];

        int j=n-1;
        int i=0;
        for(i=0;i<k;i++){
            rotate[(j+k)%n]=nums[j];
            j--;
        }
        int s=0;
        while(i<n){
            rotate[i]=nums[s];
            i++;
            s++;
        }

        // nums=Arrays.copyOf(rotate,n);

        for(int l=0;l<n;l++){
            nums[l]=rotate[l];
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
            int k=3;
            //expected output 5,6,7,1,2,3,4
       // rotate(nums,k);
        nums=new int[]{-1,-100,3,99};
        k=2;
        rotate2(nums,k);
    }
}
