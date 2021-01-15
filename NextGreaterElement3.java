import java.util.Arrays;
import java.util.HashMap;

/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n
and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
 */
public class NextGreaterElement3 {


    public int nextGreaterElement(int n) {
        String num = Integer.toString(n);
        char[] ch = num.toCharArray();

        //123
        int i=ch.length-2;
        while (i>=0 && ch[i]>ch[i+1]){
            i--;
        }
        if(i==-1)
            return -1;
        int j=ch.length-1;

        while (j>i && ch[j]<=ch[i]){
            j--;
        }

        swap(ch,i,j);

        reverse(ch,i+1);

        try {
            return Integer.parseInt(new String(ch));
        }
        catch (Exception e){
            return -1;
        }
    }

    private void reverse(char[] ch, int start) {

        int l=start;
        int r=ch.length-1;

        while (l<r){
            swap(ch,l,r);
            l++;
            r--;
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
/*

    public static void main(String[] args) {

        int n=12;
        NextGreaterElement3 nextGreaterElement3 = new NextGreaterElement3();
     //   int res = nextGreaterElement3.nextGreaterElement(n);

       // System.out.println(res);

        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        int[] res = nextGreaterElement3.nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(res));
    }

*/


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res=new int[nums1.length];

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums2.length ; i++) {
            map.put(nums2[i],i);
        }
    int j=0;
        for (int x:
             nums1) {
            Integer idx = map.get(x);
            int ele=findgreater(idx,nums2,x);
            res[j++]=ele;
        }

        return res;
    }

    private int findgreater(Integer start, int[] nums2,int element) {

        for (int i = start; i < nums2.length; i++) {
            if(nums2[i]>element)
                return nums2[i];
        }

        return -1;
    }





    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int[] nums={1,2,1};

        NextGreaterElement3 nextGreaterElement3=new NextGreaterElement3();
        int[] res = nextGreaterElement3.nextGreaterElements(nums);

        System.out.println(Arrays.toString(res));
    }
}
