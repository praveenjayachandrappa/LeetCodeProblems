class Solution {
    public boolean canJump(int[] nums) {
       int n=nums.length;
     
        int reach=0;
        
        int i=0;
        
        while(i<=reach){
            
            if(i==n-1)
                return true;
            
            reach=Math.max(reach,i+nums[i]);
            i++;
        }
               
        return false;
    }
}