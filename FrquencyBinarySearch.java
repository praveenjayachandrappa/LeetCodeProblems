import java.lang.reflect.Array;
import java.util.Arrays;

public class FrquencyBinarySearch {

   static int countOccurence=0;
    public static int findFrequency(int[] nums,int target){

        doBinarySearch(nums,0,nums.length-1,target);
        return countOccurence==0?-1:countOccurence;
    }

    private static void doBinarySearch(int[] nums, int low, int high, int key) {

        if(low>high || high<low)
            return ;
        int mid=low+(high-low)/2;
        if(nums[mid]==key){
         countOccurence++;
        doBinarySearch(nums,low,mid-1,key);
        doBinarySearch(nums,mid+1,high,key);
        }
        if(nums[mid]>key)
        doBinarySearch(nums,low,mid-1,key);
        if(nums[mid]<key)
           doBinarySearch(nums,mid+1,high,key);
    }
    private static int[] res=new int[2];
    private static int first=-1;
    private static int last=-1;
    public static int[] findFastAndLastPosition(int[] nums,int target){
            findElements(nums,0,nums.length-1,target);
            return res;
    }

    private static int findElements(int[] nums, int low, int high, int key) {
        if(low>high || high<low)
            return -1;
        int mid=low+(high-low)/2;
        if(nums[mid]==key){
         
           findElements(nums,low,mid-1,key);
           last=mid;
           findElements(nums,mid+1,high,key);
          res[0]=first!=-1?first:mid;
          res[1]=last!=-1?last:mid;
        }
        if(nums[mid]>key)
            return findElements(nums,low,mid-1,key);
        else
            return findElements(nums,mid+1,high,key);
    }

    public static void main(String[] args) {
        int[] nums={1,2,2,4,5,5,5,5,5,5,7,8};
        int target=2;
       /* int frequency = findFrequency(nums, target);
        System.out.println(frequency);
*/
        int[] fastAndLastPosition = findFastAndLastPosition(nums, target);
        System.out.println(Arrays.toString(fastAndLastPosition));

    }
}
