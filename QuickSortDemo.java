import java.util.Arrays;

public class QuickSortDemo {

    public static void main(String[] args) {

        int[] nums={17,13,2,6,8,1,-19,45,67,42,3,2,0};
        System.out.println("Input Array before sorting : "+ Arrays.toString(nums));

        int sorted[]=doQuickSort(nums,0,nums.length-1);
        System.out.println("Input Array After sorting using QuickSort Algorithm :"+Arrays.toString(sorted));

    }

    private static int[] doQuickSort(int[] nums, int low, int high) {

        if (low<high) {
            int p=partition(nums,low,high);
            doQuickSort(nums,low,p-1);
            doQuickSort(nums,p+1,high);
        }
        return nums;
    }

    private static int partition(int[] nums, int low, int high) {
        int last=nums[high];
        int i=low-1;
        int j;
        for (j = low; j <high ; j++) {
            if(nums[j]<=last){
                i++;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        int temp=nums[j];
        nums[j]=nums[i+1];
        nums[i+1]=temp;
        return i+1;
    }

}
