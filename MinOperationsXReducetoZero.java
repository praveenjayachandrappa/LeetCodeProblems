import java.util.HashMap;

public class MinOperationsXReducetoZero {

    public static int minOperations(int[] nums,int x){

        int n=nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0,sum=0; i <n && sum<=x ; i++) {
            map.put(sum,i);
            sum+=nums[i];
        }

        int result=Integer.MAX_VALUE;

        for (int r=n-1,sum=0;r>=0 && sum<=x;r--){

            if(map.containsKey(x-sum))
                result=Math.min(result,n-r-1+map.get(x-sum));
            sum+=nums[r];
        }

        return result==Integer.MAX_VALUE?-1:result;
    }


    public static void main(String[] args) {

        int[] nums={1,1,4,2,3};
        int x=5;
        int res = minOperations(nums, x);

        System.out.println(res);


    }
}
