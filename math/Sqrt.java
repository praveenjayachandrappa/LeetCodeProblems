package math;

public class Sqrt {
    /**
     *
     *
     * Given a non-negative integer x, compute and return the square root of x.
     *
     * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
     *
     * Input: x = 4
     * Output: 2
     */

    public int mySqrt(int x) {

        //return (int)Math.sqrt(x);


        //I can use binary search algorithm to find sqrt of each number x
        int low=1,high=x;

        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid*mid==x)
                return mid;
            /*
            else if(mid*mid>x)
                high=mid-1;
            else{
                low=mid+1;
                ans=mid;
            }
            */

            if(mid>=x/mid)
                high=mid-1;

            if(mid<=x/mid)
            {
                low=mid+1;
                ans=mid;
            }
        }


        return ans;
    }
}
