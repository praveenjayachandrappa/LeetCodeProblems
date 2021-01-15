import java.util.HashMap;

/**
 Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 Input: A = [4,5,0,-2,-3,1], K = 5
 Output: 7
 Explanation: There are 7 subarrays with a sum divisible by K = 5:
 [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

 */

public class SubArraySumDivisibleByK {

    public static int subarraysDivByK(int[] A, int k) {
       /* int[] count=new int[k];
            int sum=0;
        for (int x:A) {
            sum=sum+(x%k+k)%k;
            count[sum%k]++;
        }
        int result=count[0];
        for (int c:
             count) {
            result+=(c*(c-1))/2;
        }
        return result;*/
       int[] sumArray=new int[A.length];
       sumArray[0]=A[0];
        for (int i = 1; i <A.length ; i++) {
            sumArray[i]=sumArray[i-1]+A[i];
        }
        HashMap<Integer,Integer> countMap=new HashMap<>();
        for (int x:sumArray) {
            int r=(x%k+k)%k;
            countMap.put(r,countMap.getOrDefault(r,0)+1);
        }
        int result=0;
        result= countMap.get(0);
        for (int x:countMap.values()) {
            result+=(x*(x-1))/2;
        }
        return result;
    }

    public static void main(String[] args) {
/*
        int[] A = {4,5,0,-2,-3,1};
        int k = 5;
        */
    int[] A={-1,2,9};
    int k=2;
        int res = subarraysDivByK(A, k);
        System.out.println(res);


    }

}

