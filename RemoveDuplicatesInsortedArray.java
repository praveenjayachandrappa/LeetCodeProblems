public class RemoveDuplicatesInsortedArray {

    public static int removeDuplicates(int[] nums) {

        int len=0;
        int n=nums.length;
        int s=0;
        int f=s;
        while(s<n){
            while(s<n-1 && nums[s]==nums[s+1]) {
                s++;
            }
            if(s+1<=n-1) {
                nums[f + 1] = nums[s + 1];
            }
            f++;
            s++;
        }

        return f;
    }

    public static void main(String[] args) {

        int[] nums={1,1,2};
        int len = removeDuplicates(nums);
        for(int i=0;i<len;i++)
            System.out.println(nums[i]);
    }
}
