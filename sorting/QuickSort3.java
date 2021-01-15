package sorting;

import java.util.Arrays;

public class QuickSort3 {


    public static void main(String[] args) {
        int[] A={9,6,5,0,8,2,4,7,-2};
        int[] sort = quickSort(A, 0, A.length - 1);
        System.out.println("Sorted Array using QuickSort Algorithm is : "+ Arrays.toString(sort));
    }

    private static int[] quickSort(int[] nums, int low, int high) {
        if (low<high) {
            int p=parition(nums,low,high);
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
        return nums;
    }

    private static int parition(int[] nums, int low, int high) {
        int last=nums[high];
        int i=low-1;
        for (int j = low; j < high; j++) {
            if(nums[j]<=last){
                i+=1;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        int t=nums[i+1];
        nums[i+1]=last;
        nums[high]=t;
        return i+1;
    }


}
