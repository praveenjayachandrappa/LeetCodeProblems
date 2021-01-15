
import java.util.Arrays;

public class BubbleSortDemo {


    public static int[] bubbleSort(int[] nums){
        int n= nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <n-1-i ; j++) {
                if(nums[j+1]<nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
    //SC =0(1);
    //Tc=o(n^2); quadratic

    public static void main(String[] args) {


        int[] nums={7,8,4,9,-1,12,34,67,77,1,2,4,23,21};

        //7 4,8,9,12,34,1,2,4,23,21,67  //n-1 passes & n-1 comparisons
        // 4,3,2,1

        //Bubble sort is always inplace Algorithm

        int[] sort = bubbleSort(nums);

        System.out.println("Sorted Array is : "+ Arrays.toString(nums));
    }
}
