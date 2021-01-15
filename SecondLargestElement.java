import java.util.Arrays;

public class SecondLargestElement {

    private static int getSecondLargestElement(int[] nums){
        int max=nums[0];
        int secondMax=nums[0];
        for(int x:nums){
            if(x>max){
                secondMax=max;
                max=x;
            }
            else if(x>secondMax){
                secondMax=x;
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {

        int nums[]={3,9,7,8,12,6,5,4,10};
        /*int[] nums={3};*/
        /*System.out.println(getSecondLargestElement(nums));*/


        int[] numsCopy= Arrays.copyOf(nums,nums.length);
        if(Arrays.equals(nums,numsCopy)){
            System.out.println("Both arrays are equal");
        }
        System.out.println(Arrays.toString(numsCopy));
    }
}
