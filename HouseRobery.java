public class HouseRobery {

    public int rob(int[] nums) {

        if(nums.length==0)
            return 0;
        int n=nums.length;
        if(n==1) return nums[0];

        int v1=nums[0];
        int v2=Math.max(v1,nums[1]);
        for(int i=2;i<n;i++){
            int temp=v2;
            v2=Math.max(v2,nums[i]+v1);
            v1=temp;
        }
        return v2;
    }

    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};

        HouseRobery houseRobery=new HouseRobery();
        int res = houseRobery.rob(nums);
        System.out.println(res);
    }


}
