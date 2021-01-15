import java.util.Arrays;

public class SumOfSubset {

    //sum of subset problem
    //Tc=(n*sum)
        public static boolean canPartition(int[] nums) {
            int sum = 0;
            for(int i : nums) {
                sum += i;
            }
            if ((sum &1) != 0) return false;
            int target = sum >> 1;
            boolean[] dp = new boolean[ target+1];
            Arrays.fill(dp, false);
            dp[0] = true;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                for(int j = target; j >= num; j--) {
                   // dp[j] |= dp[j-num];
                    dp[j]=dp[j]|dp[j-num];
                }
            }
            return dp[target];
        }

    public static void main(String[] args) {


            int[] set={1,5,11,5};
        boolean b = canPartition(set);

        System.out.println(b);
    }
}
