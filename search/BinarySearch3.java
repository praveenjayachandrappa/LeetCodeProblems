package search;

public class BinarySearch3 {

    public static void main(String[] args) {

        int[] nums={1,2,3,4,5};

        int key=0;

        /*int i = doBinarySearch(nums, 0, nums.length - 1, key);
        System.out.println(i);

        */
        int index=binarySearch_Iterative(nums,key);

        System.out.println(index);
    }
    //Binary search works only for sorted array & it gives the time complexity of o(nlogn)

    private static int doBinarySearch(int[] nums,int low,int high,int key){
    if(low>high || high<low)
            return -1;
        int mid=low+(high-low)/2; //low+high/2;
        if(nums[mid]==key)
            return mid;
        if(key<nums[mid])
       return doBinarySearch(nums,low,mid-1,key);
        else
          return  doBinarySearch(nums,mid+1,high,key);

    }

    private static int binarySearch_Iterative(int[] nums,int key){
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==key)
                return mid;
            if(key<nums[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
