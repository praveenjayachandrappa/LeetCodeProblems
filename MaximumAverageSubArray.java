import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumAverageSubArray {

    public double findMaxAverage(int[] nums, int k) {

        Deque<Integer> deque=new ArrayDeque<>(k);
       double maxAverage=Integer.MIN_VALUE;
        double sum=0;
        for (int i = 0; i <nums.length ; i++) {
            if(deque.size()==k){
                maxAverage=Math.max(sum/k,maxAverage);
                 sum-=deque.pollFirst();
            }
            sum+=nums[i];
            deque.add(nums[i]);
        }
        if(maxAverage==Integer.MIN_VALUE)
            maxAverage=sum;
        else if(deque.size()==k){
            sum=0;
            for (int x:deque) {
                sum+=x;
            }
            maxAverage=Math.max(maxAverage,sum/k);
        }
        return maxAverage;

        }

    public static void main(String[] args) {

  /*      int[] nums= {1,12,-5,-6,50,3};
        int k=4;*/
        /*int[] nums={5};
        int k=1;*/
/*
        int[] nums={0,1,1,3,3};
        int k=4;*/

        int[] nums={4,0,4,3,3};
        int k=5;
        MaximumAverageSubArray maximumAverageSubArray=new MaximumAverageSubArray();
        double maxAverage = maximumAverageSubArray.findMaxAverage(nums, k);

        System.out.println(maxAverage);
    }
}
