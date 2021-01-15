public class MaxProfit {


    private static int getMaxProfit(int[] nums,int n){

        if(nums.length==0)
            return 0;
        int res[]=new int[n];
        res[0]=nums[0];
        int max=Integer.MIN_VALUE;
        for(int j=1;j<n;j++){
            int i=j-1;
            int temp=nums[j];
            while(i>=0){
                if(nums[j]%nums[i]==0) {
                    temp += res[i];
                    break;
                }
                i--;
            }
            max=Math.max(max,temp);
            res[j]=temp;
        }

        return max;

    }

    public static void main(String[] args) {

        int[] arr={1,2,3,4,9,8};
        int n=6;
        int maxProfit = getMaxProfit(arr, n);

    /*    float[] arr3=new float[5];
        Object f=arr3;
        System.out.println(f[0]);
    */
    }
}
