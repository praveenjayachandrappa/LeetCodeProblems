import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {


    public static void main(String[] args) {
        //by default Priority queue crates min Heap and Collections.reverseOrder() then it will create max Heap
         PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.addAll(Arrays.asList(33,13,10,20,2,3,5,6,8));
        /*priorityQueue.forEach(a->System.out.print(a+" "));*/
        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll()+" ");
        }
    }
}
