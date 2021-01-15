public class RoatedBinarySearch {
    /*public int search(int[] nums, int target) {
        return doBinarySearch(nums,0,nums.length-1,target);
    }
    private int doBinarySearch(int[] nums,int low,int high,int key){

        if(low>high || high<low)
            return -1;

        int mid=low+(high-low)/2;

        if(nums[mid]==key)
            return mid;

        if(key<nums[mid] && nums[mid+1]<nums[mid])
            return doBinarySearch(nums,mid+1,high,key);
        if(key>nums[mid] && nums[mid+1]>nums[mid])
            return doBinarySearch(nums,mid+1,high,key);
        else
            return doBinarySearch(nums,low,mid-1,key);
    }*/


    public  static int search(int[] nums, int target) {
        if(nums.length==1 && target!=nums[0])
            return -1;

        int low=0;
        int high=nums.length-1;

        while(low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]==target)
                return mid;

            if(target>=nums[low])
                high=mid-1;
            else
                low=mid+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        /*int[] nums={4,5,6,7,0,1,2};
        int target=2;*/
    /*    *//*int[] nums={1,3};
        int target=3;*//*
        RoatedBinarySearch roatedBinarySearch=new RoatedBinarySearch();
        int idx = roatedBinarySearch.search(nums, target);
        System.out.println(idx);
    */

        int[] nums={5,1,3};
        int target=5;
        int idx = search(nums, target);

        System.out.println(idx);
    }
}
