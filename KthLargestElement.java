import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {


    public static int findKthLargest(int[] nums, int k) {
        /*Arrays.sort(nums);

        int n=nums.length-1;
        int count=1;
        for(int i=n-1;i>=0;i--){
            if(count==k)
                return nums[i];
            count++;
        }

        return 0;*/

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for (int x:nums){
            minHeap.add(x);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {

        int[] nums={3,2,1,5,6,4};
        int k=6;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
