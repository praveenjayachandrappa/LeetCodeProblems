import java.util.Arrays;

public class InsertionSort {

    private int[] doInsertionSort(int[] nums){
        for (int i = 1; i <nums.length ; i++) {
            int key=nums[i];
            int j=i-1;
            while (j>=0){
                if(key<nums[j]){
                    nums[j+1]=nums[j];
                    j--;
                }
                else {
                    break;
                }
            }
            nums[j+1]=key;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={57,78,5,8,2,3,6,7,1};
        System.out.println("The given input array is : "+ Arrays.toString(nums));
        int[] sorted = new InsertionSort().doInsertionSort(nums);
        System.out.println("The sorted array using Insertion sort is : "+Arrays.toString(sorted));
    }

}
