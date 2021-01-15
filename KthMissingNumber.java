public class KthMissingNumber {
    public static int findKthPositive(int[] arr, int k) {

        int[] store=new int[10001];

        for (int i = 0; i < arr.length ; i++) {
            store[arr[i]]=1;
        }
        int count=0;
        for (int i = 1; i <store.length; i++) {
            if(store[i]==0)
                count++;
            if(count==k)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={2,3,4,7,11};
        int k=5;
        int kthPositive = findKthPositive(nums, k);
        System.out.println(kthPositive);

    }
}
