import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class RemoveInterval {

    public int sortInterval(int[][] intervals){

        Arrays.sort(intervals,(cur,existing)->{
            if(cur[0]==existing[0])
                return -(cur[1]-existing[1]);
            else
                return (cur[0]-existing[0]);
        });

        Arrays.stream(intervals).forEach(arr-> System.out.println(Arrays.toString(arr)));


        int maxEnd=0;
        int res=intervals.length;
        for(int[] cur:intervals){

            int curEnd=cur[1];

            if(curEnd<=maxEnd){
                res--;
            }
            maxEnd=Math.max(curEnd,maxEnd);
        }


        return res;
    }

    public int removeCoveredIntervals(int[][] intervals) {
    /*    HashSet<Integer> set=new HashSet<>();
        int res=0;
        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<intervals.length;j++){
                if(i==j || set.contains(i)) continue;
                if(intervals[j][0]<=intervals[i][0] && intervals[i][1]<=intervals[j][1]) {
                    res++;
                    set.add(i);
                }
            }
        }

        return intervals.length-res;
    */

    int res=0;
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0]==i2[0])
                 return i1[1]-i2[1];
            if (i1[0]<=i2[0])
                return -1;
            return 1;
        });
        int start=intervals[0][0];
        int end=intervals[0][1];
            for (int i=1;i<intervals.length;i++) {
            /*    if(intervals[i][1]<=max)
                    res++;
                    max=Math.max(max,intervals[i][1]);
            */

            if(intervals[i][0]==start && intervals[i][1]>=end){
                res++;
            }
             if(intervals[i][0]>=start && intervals[i][1]<=end){
                res++;
            }
             start=intervals[i][0];
             end=intervals[i][1];
            }
        return  intervals.length-res;
        }

        //Arrays.stream(intervals).forEach(a-> System.out.println(Arrays.toString(a)));


    public static void main(String[] args) {

       //int[][] intervals={{3,10},{4,10},{5,11}};
    //int[][] intervals  ={{1,4},{3,6},{2,8}};

       //int[][] intervals={{34335,39239},{15875,91969},{29673,66453},{53548,69161},{40618,93111}};
     //   int[][] intervals={{1,2},{1,4},{3,4}};
    /*        RemoveInterval removeInterval=new RemoveInterval();
        int res = removeInterval.removeCoveredIntervals(intervals);
        System.out.println(res);
    */

    int[][] intervals={{1,2},{1,4},{3,4}};
        int res = new RemoveInterval().sortInterval(intervals);
        System.out.println(res);
    }
}
