package arrays;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 *
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109

 */
public class MaximumNumberofKSumPairs {

    public int maxOperations(int[] nums, int k) {

        /*
        int n=nums.length;

        int count=0;
        for(int i=0;i<n-1;i++){
            int key=nums[i];
            if(key==-1) continue;
            for(int j=i+1;j<n;j++){
                if(nums[j]!=-1 && key+nums[j]==k){
                    count++;
                    nums[j]=-1;
                    break;
                }
            }
            nums[i]=-1;
        }


        return count;

        */
        ///////////////////////////////////////////

        /*
        Map<Integer,Integer> map=new HashMap();

        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int count=0;
        for(int x:map.keySet()){


            if(map.containsKey(x) && map.containsKey(k-x)){

                if(x!=k-x){
                    count+=Math.min(map.get(x),map.get(k-x));
                    map.put(x,0);
                    map.put(k-x,0);
                }
                else{
                    count+=Math.floor(map.get(x)/2);
                }

            }

        }

        return count;
        */




        //nlogn time complexity
        //Space time complexity is o(1)
        Arrays.sort(nums);

        int low=0;
        int high=nums.length-1;

        int count=0;
        while(low<high){
            if(nums[low]+nums[high]==k){
                count++;
                low++;
                high--;
            }

            else if(nums[low]+nums[high]>k)
                high--;
            else
                low++;

        }

        return count;

    }

    public static void main(String[] args) {

        //input value to the method.
/*
        Input: nums = [3,1,3,4,3], k = 6
        Output: 1
        Explanation: Starting with nums = [3,1,3,4,3]:
        - Remove the first two 3's, then nums = [1,4,3]
        There are no more pairs that sum up to 6, hence a total of 1 operation.*/

    }


}
