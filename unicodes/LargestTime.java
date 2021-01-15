package unicodes;

public class LargestTime {
    private boolean bound(int maxBound,int index,int[] a){
        int max = -1;
        for(int i = index; i<a.length;i++) if(a[i]<=maxBound && (max==-1 || a[max]<a[i])) max = i;
        if(max==-1) return false;
        // swap it put at correct position
        int temp = a[max];
        a[max] = a[index];
        a[index] = temp;
        return true;
    }

    public String largestTimeFromDigits(int[] a) {
        boolean res = (bound(2,0,a) && (a[0]==2 ? bound(3,1,a) : bound(9,1,a)) && bound(5,2,a) && bound(9,3,a)) || (bound(1,0,a) && bound(9,1,a) && bound(5,2,a) && bound(9,3,a));


        StringBuilder sb = new StringBuilder();

        if(!res) return sb.toString();

        return sb.append(String.valueOf(a[0]))
                .append(String.valueOf(a[1]))
                .append(':')
                .append(String.valueOf(a[2]))
                .append(String.valueOf(a[3])).toString();
    }

    public static void main(String[] args) {
/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 */

    }
}
