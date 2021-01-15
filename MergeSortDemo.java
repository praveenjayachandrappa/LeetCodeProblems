import java.util.Arrays;

public class MergeSortDemo {


    public static void main(String[] args) {

        int[] nums={17,13,2,6,8,1,-19,45,67,42,3,2,0};
        System.out.println("Input Array before sorting : "+ Arrays.toString(nums));

        int sorted[]=doMergeSort(nums,0,nums.length-1);
        System.out.println("Input Array After sorting using MergeSort Algorithm :"+Arrays.toString(sorted));

    }

    private static int[] doMergeSort(int[] nums, int low,int high) {
        if (low<high) {
            int mid=low+(high-low)/2;
            doMergeSort(nums, 0, mid);
            doMergeSort(nums,mid+1,high);
            merge(low,mid,high,nums);
        }
        return nums;
    }

    private static void merge(int low, int mid, int high,int[] nums) {
            int[] left=new int[mid-low+1];
            int[] right=new int[high-mid];
        for (int i = 0; i < left.length; i++) {
            left[i]=nums[i+low];
        }
        for (int j = 0; j <right.length ; j++) {
            right[j]=nums[mid+1+j];
        }
        int k=low;
        int i=0,j=0;
        while (i<left.length && j<right.length){
            if(left[i]<right[j])
                nums[k++]=left[i++];
            else
                nums[k++]=right[j++];
        }
        //copy the remaining elements
        while (i<left.length)
            nums[k++]=left[i++];
        while (j<right.length)
            nums[k++]=right[j++];
    }
}
