/*



Problem 2:

Suppose an array sorted in ascending order is rotated x times (circular left shifts).

let array ={0,1,2,4,5,6,7}; might become {4,5,6,7,0,1,2}

Findx x: (1<=x=<n-1)

you may assume no duplicates in the array
 */
public class NumberOfRoationsOnSortedArray {


    public static int findLeftRoations(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int rp = -1;
        if(nums[low]<nums[high] || nums[high]>nums[low])
            return 0;
        while (low<=high) {

            int mid = low + (high - low) / 2;
            if(nums[mid]>nums[mid+1]){
                rp=mid+1;
                break;
            }
            if(nums[mid]<nums[mid-1]){
                rp=mid;
                break;
            }
            if(nums[mid]>nums[low])
                low=mid+1;
            else
                high=mid-1;
        }

        if (rp != -1)
            return nums.length - rp;
        else
            return -1;
    }

    public static void main(String[] args) {

        int[] nums={6,7,0,1,2,4,5};


        int leftRoations = findLeftRoations(nums);

        System.out.println(leftRoations);

    }
}

