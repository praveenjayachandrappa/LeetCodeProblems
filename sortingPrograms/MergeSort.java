package sortingPrograms;

import java.util.Arrays;

public class MergeSort {

        public static int[] mergSort(int[] nums,int low,int high){
            if(low<high){
                int mid=(low+high)/2;
                mergSort(nums,low,mid);
                mergSort(nums,mid+1,high);
                merge(nums,low,mid,high);
            }
            return nums;
        }
        //T(n)=T(n/2)+T(n/2);
        //T(n/2)=T(n/4)+T(n/4) if n>1
    //if(n==1)
        //T(c)=o(nlogn)
        //S(C) =0(N);
    private static void merge(int[] nums, int low, int mid, int high) {
            int n1=mid-low+1;
            int n2=high-mid;
            int[] left=new int[n1];
            int[] right=new int[n2];
        for (int i = 0; i <n1 ; i++) {
            left[i]=nums[i+low];
        }
        for (int j = 0; j < n2; j++) {
            right[j]=nums[mid+1+j];
        }
        int k=low;
        int i=0,j=0;
        while (i< left.length && j< right.length){
            if(left[i]<right[j]){
                nums[k++]=left[i++];
            }
            else {
                nums[k++]=right[j++];
            }
        }
        //copy the remaining elements

        while (i<left.length){
            nums[k++]=left[i++];
        }
        while (j< right.length){
            nums[k++]=right[j++];
        }
    }

    public static void main(String[] args) {

            //int nums={1,2,3,4,5}

        int[] nums={7,8,4,9,-1,12,34,67,77,1,2,4,23,21};

        int[] sort = mergSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(sort));
    }
}

