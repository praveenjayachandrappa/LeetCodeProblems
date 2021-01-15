import java.util.HashSet;

public class CreateSortedArray {


    public int createSortedArray(int[] instructions) {
//        int costOfInsertion = 0;
//        int max = 0;
//        for (int x :
//                instructions) {
//            max = Math.max(x, max);
//        }
//
//        int[] nums = new int[max + 1];
//
//        for (int x : instructions) {
//            nums[x] +=1;
//            costOfInsertion+=getInsertionCost(x,nums,max);
//            costOfInsertion=costOfInsertion%(1000000000+7);
//        }
//
//        return costOfInsertion;



        int max=0;
        for (int x:
             instructions) {
            max=Math.max(x,max);

        }

        Fenwick fenwick=new Fenwick(max+2);

            int res=0;
        for (int i = 0; i < instructions.length; i++) {
            int curr = instructions[i];
            int lower= fenwick.sumRange(0,curr-1);
            int higher=fenwick.sumRange(curr+1,max);
            res=res+Math.min(lower,higher);
            res=res%1000000007;
            fenwick.update(curr,1);
        }
        return res;
    }
/*

    private int getInsertionCost(int i,int[] nums,int max) {
        int left=0;
        int right=0;
        int begin=1;
        while (begin<i){
            if(nums[begin]!=0){
                left+=nums[begin];
            }
            begin++;
        }
        int end=i+1;
        while (end<=max){
                if(nums[end]!=0) {
                    right+=nums[end];
                }
                end++;
        }
        return Math.min(left,right);


    }
*/

    public static void main(String[] args) {

        //int[] instructions={1,5,6,2};
        int[] instructions={1,3,3,3,2,4,2,1,2};
        CreateSortedArray obj=new CreateSortedArray();
        int res = obj.createSortedArray(instructions);
        System.out.println(res);

    }
}

class Fenwick{

    int[] arr;

    public Fenwick(int len){
        arr=new int[len];
    }

    //sum
    public int sumRange(int beg,int end){

        return sum(end+1)-sum(beg);

    }

    private int sum(int i) {
        int sum=0;
        while (i>0){
                sum=sum+arr[i];
                i=i-(i&-i);

        }
        return sum;
    }

    //update count

    public void update(int i,int val){
        i++;
        while (i<arr.length){

            arr[i]=arr[i]+val;
            i=i+(i&-i);
        }
    }
}