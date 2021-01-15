package sortingPrograms;

import inheritance.multipleInheritance.A;

import java.util.Arrays;

public class InsertionSort {


    public static int[] doInsertionSort(int[] nums){
        int n=nums.length;
        int i=0;
        //2,1
        for (int j = 1; j<n; j++) {
            i=j-1;
            int key=nums[j];
                while (i>=0 && key<nums[i]) {
                    nums[i+1]=nums[i];
                    i--;
                }
               nums[i+1]=key;
            }
        return nums;
        }
    public static void main(String[] args) {

       // int[] nums={7,8,4,9,12,34,67,77,1,2,4,23,21};
        int[] nums={2,1};
        int[] sort = doInsertionSort(nums);

        System.out.println(Arrays.toString(sort));
    }
}
