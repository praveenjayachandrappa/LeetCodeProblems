package sorting;

import java.util.Arrays;

public class MergeSortedLists {

    public  static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=0,j=0;
        int k=0;
        int key;
        while(i<m && j<n){
            key=nums1[k];
            if(key<nums2[j]){
                nums1[k++]=nums1[i++];
            }
            else{
                nums1[k++]=nums2[j++];
            }
        }

        //copy the remaing elements at last

        while(i<m)
            nums1[k++]=nums1[i++];
        while(j<n)
            nums1[k++]=nums2[j++];

    }

    public static void main(String[] args) {

        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=nums1.length;
        int n= nums2.length;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
