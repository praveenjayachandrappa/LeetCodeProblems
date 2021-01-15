import java.util.Arrays;
import java.util.HashMap;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
/*
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]==0){
                int j=i+1;
                while (j<n && nums[j]==0) {
                    j++;
                }
                if(j<n) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }*/

        //In place algorithm
        int leftIdx=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) {
                nums[leftIdx]=nums[i];
                leftIdx++;
            }
        }

        while (leftIdx<nums.length){
            nums[leftIdx]=0;
            leftIdx++;
        }
    }
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(target-nums[i])){
                int s=map.get(target-nums[i]);
                return new int[]{s,i};
            }
            map.put(nums[i],i);
        }

        return null;
    }

    public static void main(String[] args) {

        int[] nums={0,1,0,3,12};
        MoveZeros moveZeros=new MoveZeros();
        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
