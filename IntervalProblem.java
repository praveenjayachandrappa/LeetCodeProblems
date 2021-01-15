import java.util.ArrayList;
import java.util.Arrays;

public class IntervalProblem {
    public  int[][] insert(int[][] intervals, int[] newInterval) {
         ArrayList<int[]> res=new ArrayList<>();
         int i=0;
         int n=intervals.length;
         while (i<n && intervals[i][1]<newInterval[0])
             res.add(intervals[i++]);
         int[] mi=newInterval;
         while (i<n && intervals[i][0]<=newInterval[1]){
             mi[0]=Math.min(intervals[i][0],mi[0]);
             mi[1]=Math.max(intervals[i][1],mi[1]);
             i++;
         }
         res.add(mi);

         while (i<n) {
             res.add(intervals[i]);
             i++;
         }
        int[][] result = res.toArray(new int[res.size()][2]);

         return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        /*int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
    */    int[][] insert;
       insert = new IntervalProblem().insert(intervals, newInterval);
        for (int[] x:
             insert) {
            System.out.println(Arrays.toString(x));
        }
    }
}
