import java.util.Arrays;

public class KdiffPairs {
    public int findPairs(int[] nums, int k) {
        if (nums.length <= 1) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            if (diff == k) count++;
            if (diff <= k) {
                // goes to the next time different from nums[right];
                int num = nums[right];
                right++;
                while (right < nums.length && nums[right] == num) {
                    right++;
                }
            } else {
                left++;
                if (left == right) {
                    right++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums={3,1,4,1,5};
        KdiffPairs obj=new KdiffPairs();
        int pairs = obj.findPairs(nums, 2);
        System.out.println(pairs);
    }
}
