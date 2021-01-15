import java.util.Arrays;

public class HIndexProblem {
    /**
     Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

     According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

     Example:

     Input: citations = [3,0,6,1,5]
     Output: 3
     Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
     received 3, 0, 6, 1, 5 citations respectively.
     Since the researcher has 3 papers with at least 3 citations each and the remaining
     two with no more than 3 citations each, her h-index is 3.


     */
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int n=citations.length;
        // Arrays.sort(citations,Collections.reverseOrder());
        Arrays.sort(citations);
        reverse(citations);
        int h=0;
        for(int i=1;i<=n;i++){
            if(citations[i-1]>=i){
                h=Math.max(h,i);
            }
        }
        if(h==0) return 0;
        return h;
    }

    private void reverse(int[] arr) {
        int f=0,r=arr.length-1;
        while (f<=r){
            int temp=arr[f];
            arr[f]=arr[r];
            arr[r]=temp;
            r--;
            f++;
        }
    }
}
