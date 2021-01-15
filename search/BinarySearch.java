package search;

import java.util.Arrays;

/**
 * Binary Search works only for sorted array and it gives time complexity of o(logn)
 */
public class BinarySearch {


    public int dinarySearchwithIndex(int[] nums, int key, int low, int high){
        if(low>high || high<low)
            return -1;
        int mid=low+(high-low)/2;
        if(nums[mid]==key)
            return mid;
        if(key>nums[mid])
            return dinarySearchwithIndex(nums,key,mid+1,high);
        else
            return  dinarySearchwithIndex(nums,key,low,mid-1);
    }
    public boolean doBinarySearch(int[] nums,int key,int low ,int high){
        //1 3 5 6 7 8 9
        if(low>high || high<low)
            return false;
        int mid=low+(high-low)/2; // low+high/2;
        if(nums[mid]==key) return true;
        if(key>nums[mid])
           return doBinarySearch(nums,key,mid+1,high);
        else
        return doBinarySearch(nums,key,low,mid-1);
    }


    public static void main(String[] args) {
        //int[] nums={4,5,2,10,13,12,18,16,45,34,29};Arrays.sort((nums));
        int[] nums={2,3,5,6,7,9,10,12};
        int key=2;
        BinarySearch binarySearch =new BinarySearch();
        //System.out.println(binarySearch.doBinarySearch(nums,key,0,nums.length-1));

        System.out.println(binarySearch.dinarySearchwithIndex(nums,key,0,nums.length-1));
    }
}
