import java.util.*;

/**
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 */
public class SlidingWindowMaximum {

    public  static int[] maxSlidingWindow(int[] nums, int k) {
       /* PriorityQueue<Integer> pq=new PriorityQueue<>(k, Collections.reverseOrder());
        List<Integer> list=new ArrayList<>();
        int i=0;
        for(int x:nums){
            pq.add(x);
            if(pq.size()==k) {
                list.add(pq.peek());
                pq.remove(new Integer(nums[i]));
                i++;
            }
        }
*/
      //  System.out.println(pq);


        int n=nums.length;
      //  List<Integer> list=new ArrayList<>();
        int[] output=new int[n-k+1];
        int j=0;
        Deque<Integer> index=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (index.size()>0 && index.getFirst()<=i-k){
                index.removeFirst();
            }
            while (index.size()>0 && nums[i]>=nums[index.getLast()])
            {
                index.removeLast();
            }
                  index.addLast(i);
            if(i>=k-1)
                //list.add(nums[index.getFirst()]);
                output[j++]=nums[index.getFirst()];
        }
        //return list.stream().mapToInt(x->x).toArray();
        return output;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(res));
    }

}
