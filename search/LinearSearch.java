package search;

public class LinearSearch {

    public int getIndexofKeyElement(int[] nums,int key){

        for (int i = 0; i <nums.length;i++) {
            if(nums[i]==key)
                return i;
        }
        return -1;
    }
    public boolean doLinearSearch(int[] nums,int key){
        for (int x:
                nums) {
            if(key==x)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums={4,5,2,10,13,12,18,16,45,34,29};
        int key=89;
        System.out.println(new LinearSearch().doLinearSearch(nums,key) +" with Index : "+new LinearSearch().getIndexofKeyElement(nums,key));

    }

}
