package permutations;

import java.util.Arrays;

public class NextPermutation {

    /**
     *
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
     *
     * The replacement must be in place and use only constant extra memory.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     *
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     *
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * Example 4:
     *
     * Input: nums = [1]
     * Output: [1]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100

     */


    public static void nextPermutation(int[] nums) {

        int i= nums.length-2;

        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if(i>=0){

            int j= nums.length-1;

            while (j>=0 && nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }

        reverse(nums,i+1);
    }

    private static void reverse(int[] nums, int start) {
        int end= nums.length-1;
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public static void main(String[] args) {


        //int[] nums={1,1,5,4,6};

        //int[] nums={1,4,1,1,5};

        int[] nums={1,3,2};
       // int[] nums={1,1,5,4,1};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
