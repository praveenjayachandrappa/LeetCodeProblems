package Queue;

public class ImplementQueue {

    // Queue is FiFO data structre

    private int[] queue;
    private int front;
    private int rear;
    public  ImplementQueue(int size){
        queue=new int[size];
        front=rear=-1;
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is Full ");
            return;
        }
        rear++;
        queue[rear]=val;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return rear==queue.length-1;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        front++;
        return queue[front];
    }

    public static void main(String[] args) {

        ImplementQueue implementQueue=new ImplementQueue(10);
        implementQueue.enqueue(1);
        implementQueue.enqueue(2);
        int dequeue = implementQueue.dequeue();
        System.out.println(dequeue);
        int dequeue1 = implementQueue.dequeue();
        System.out.println(dequeue1);
        int dequeue3 = implementQueue.dequeue();
        System.out.println(dequeue3);
    }
}
