package search;

/**
 * You are given an integer array nums sorted in ascending order, and an integer target.
 *
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * If target is found in the array return its index, otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        if(nums.length==0)
            return -1;

        int low=0;
        int high=nums.length-1;
        int first=nums[nums.length-1];
        while(low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]==target)
                return mid;

            boolean amBig=nums[mid]>=first;
            boolean istargetBig=target>=first;

            if(amBig==istargetBig){

                if(nums[mid]<target)
                    low=mid+1;
                else
                    high=mid-1;

            }
            else{

                if(amBig)
                    low=mid+1;
                else
                    high=mid-1;

            }

        }

        return -1;
    }

    private static  int search_secondMethod(int[] nums,int target){

        if(nums.length==0)
            return -1;

        int low=0;
        int high=nums.length-1;

        //first find the smallest element index
        while (low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[high])
                low=mid+1;
            else
                high=mid;
        }

        int start=low;
        low=0;
        high=nums.length-1;

        //based on the target value

        if(target>=nums[start] && target<=nums[high]){
            low=start;
        }
        else{
           high=start;
        }

        while (low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        /*int[] arr={4,5,6,7,0,1,2};
        int target=2;
        int index = search(arr, target);
        System.out.println(index);*/

/*        int[] nums={1,3,1,1,1};
        int target=3;
        int index = search(nums, target);
        System.out.println(index);*/



        /**
         * Using second method search2()
         */
        int[] arr={4,5,6,7,0,1,2};
        int target=2;
       int index=search_secondMethod(arr,target);
        System.out.println(index);

        int[] arr1={3,1,1};
        int target1=3;
        int index1=search_secondMethod(arr1,target1);
        System.out.println(index1);



    }

}
