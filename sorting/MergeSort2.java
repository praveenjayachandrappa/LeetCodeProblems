package sorting;

import java.util.Arrays;

public class MergeSort2 {


    /**
     * Merge Sort Algorithm and time Complexity of merge Sort Algorithm is o(nlogn)
     *
     */

    private int[] doMergeSort(int[] nums,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            doMergeSort(nums,low,mid);
            doMergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }

        return nums;
    }

    private void merge(int[] nums, int low, int mid, int high) {

        int n1=mid-low+1;
        int n2=high-mid;

        int[] left=new int[n1];
        int[] right=new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i]=nums[low+i];
        }

        for (int i = 0; i <n2 ; i++) {
            right[i]=nums[mid+1+i];
        }
        int k=low;
        int i=0,j=0;
        while (i<n1 && j<n2){
            if(left[i]<right[j])
                nums[k++]=left[i++];
            else
                nums[k++]=right[j++];
        }

        //copy the remaining elements
        while (i<n1){
            nums[k++]=left[i++];
        }

        while (j<n2){
            nums[k++]=right[j++];
        }
    }

    public static void main(String[] args) {

        int[] nums={4,5,2,10,13,12,18,16,45,34,29,2};
        //int[] nums={16,9};
        System.out.println("The given input array is : "+ Arrays.toString(nums));
        int[] sort = new MergeSort2().doMergeSort(nums,0,nums.length-1);
        System.out.println("The sorted array using merge sort is : "+Arrays.toString(sort));

    }
}
