import java.util.Arrays;

/*

 Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
 */
public class LongestSubSequence {

    public static int lengthOfLIS(int[] nums) {

        int n=nums.length;

        int[] dp=new int[n];

        Arrays.fill(dp,1);
        int lis=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

            lis=Math.max(lis,dp[i]);
        }

        return lis;
    }


    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        int[] length = new int[n], count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        int lis = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            lis = Math.max(lis, length[i]);
        }

        int numLis = 0;
        for (int i = 0; i < n; i++)
            if (length[i] == lis)
                numLis += count[i];

        return numLis;
    }

    public static void main(String[] args) {


    /*
     Finding Length of longest increasing subsequence
     int[] arr={10,9,2,5,3,7,101,18};

        int res = lengthOfLIS(arr);

        System.out.println(res);

    */


        int[] nums = {1,3,5,4,7};
        int numberOfLIS = findNumberOfLIS(nums);

        System.out.println(numberOfLIS);

    }
}
