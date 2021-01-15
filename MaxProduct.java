public class MaxProduct {

    public int maxProduct(int[] nums) {
        int globalMax=Integer.MIN_VALUE;
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length-1;i++){
            int temp=nums[i];
            for(int j=i+1;j<nums.length;j++){
                int r=temp*nums[j];
                globalMax=Math.max(nums[j],Math.max(r,globalMax));
                temp=r;
            }
            if(nums[i]>globalMax){
                globalMax=nums[i];
            }
        }

        return globalMax;
    }
    public static void main(String[] args) {

       // int[] nums={-2,0,-1};
        int[] nums={0,2};
        System.out.println(new MaxProduct().maxProduct(nums));
    }
}
