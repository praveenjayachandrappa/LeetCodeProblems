import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SaveBoats {


    public  static int numRescueBoats(int[] people, int limit) {
        if (people.length == 0)
            return 0;
        //Arrays.sort(people); //1,2,2,3  //limit 3
        int boat=0;
        PriorityQueue<Integer>  pq=new PriorityQueue<>();
        for (int x:
             people) {
            pq.add(x);
        }
        int sum=0;
        int count=0;
        while (!pq.isEmpty()){
            sum+=pq.poll();
            if(sum==limit) {
                boat++;
                sum=0;
                count=0;
            }
            if(sum>limit){
                count++;
                boat+=count;
                sum=0;
                count=0;
            }
            else {
                count++;
            }
        }
        return boat;
    }

    public static void main(String[] args) {

        int[] people={1,2,2,3};
       //int[] people={2,4};
        //int[] people={3,5,3,4};
        int limit=3;
        int numRescueBoats = numRescueBoats(people, limit);

        System.out.println(numRescueBoats);
    }
}
