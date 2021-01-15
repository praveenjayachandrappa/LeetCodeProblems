import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

import java.util.Arrays;
public class BinarySearchFirstAndLastPosition {
   /*static int[] res=new int[2];
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};
        doBinarySearch(nums,0,nums.length-1,target);
        return res;

    }

    private static void doBinarySearch(int[] nums, int low, int high, int target) {

        if(low>high || high<low) {
            res[0]=-1;
            res[1]=-1;
            return;
        }
        int mid=low+(high-low)/2;
        if(nums[mid]==target){
            int first=mid;
            int first_Res=mid;
            while (true){
                first=searchwithRange(nums,0,first-1,target);
                if(first!=-1)
                    first_Res=first;
                else
                    break;
            }
            int lastRes=mid;
            int last=mid+1;
            while (true){
                last=searchwithRange(nums,last,nums.length,target);
                if(last!=-1 && lastRes!=last)
                    lastRes=last;
                else
                    break;
            }
            res[0]=first_Res;
            res[1]=lastRes;
            return;
        }
        if(nums[mid]<target)
        doBinarySearch(nums,mid+1,high,target);
        else
            doBinarySearch(nums,low,mid-1,target);
    }

    private static int searchwithRange(int[] nums,int low,int high,int key){
        if(low>high || high<low)
            return -1;
        int mid=low+(high-low)/2;
        if(nums[mid]==key)
            return mid;
        if(nums[mid]<key)
        return searchwithRange(nums,mid+1,high,key);
        else
            return searchwithRange(nums,low,mid-1,key);
    }*/
    public static void main(String[] args) {
    /*   *//* int[] nums={5,7,7,8,8,10};
        int target=6;*//*
        *//*int[] nums={1};
        int target=1;*//*
*//*
        int target=2;
        int[] nums={2,2};*//*
        int[] nums={1};
        int target=1;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    */
   /*     int[] nums={5,7,7,8,8,10};
        int target=8;*/
        int[] nums={1};
        int target=1;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int first=first_pos(nums,target);
        int last=first_pos(nums,target+1)-1;

        if (first<=last)
            return new int[]{first,last};
        else
            return new int[]{-1,-1};

    }
    private static int first_pos(int[] nums,int key){

        int low=0;
        int high=nums.length-1;
        int first_pos=nums.length;
        while (low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]>=key){
                first_pos=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }

        return first_pos;
    }
}
