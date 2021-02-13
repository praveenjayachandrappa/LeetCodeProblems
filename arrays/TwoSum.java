package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     */

    public static int[] twoSum(int[] nums, int target) {

        int n=nums.length;
        /*
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]==target-nums[i])
                    return new int[]{i,j};
            }
        }

        return null;
        */

        //TC-0(N);
        //SC-o(N)
        HashMap<Integer,Integer> map=new HashMap();

        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                int x=target-nums[i];
                return new int[] {map.get(x),i};
            }
            else
                map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums={2,7,11,15};
        int target=9;

        int[] indx = twoSum(nums, target);

        System.out.println(Arrays.toString(indx));
    }
}
