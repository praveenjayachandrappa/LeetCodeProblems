package threads;

class SharedObject{

    int value;
    boolean flag=true;
    public  void setValue(int value) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            while (flag!=true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.value = value;
            flag=false;
            notify();
        }
    }

    public int getValue() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            while (flag!=false)
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        int x=this.value;
                flag=true;
                notify();
                return x;
        }
    }
}


class Producer extends  Thread{
    SharedObject sharedObject;
        Producer(SharedObject sharedObject){
                this.sharedObject=sharedObject;
            }
    @Override
    public void run() {
        int count=0;
        while (count<=10){
            count++;
            sharedObject.setValue(count);
            System.out.println("Producer Thread :"+count+":"+this.getName());
        }
    }
}
class Consumer extends Thread{

    SharedObject sharedObject;
    Consumer(SharedObject sharedObject){
        this.sharedObject=sharedObject;
    }

    @Override
    public void run() {
        int count=0;
        while (count<=10){
            int x=sharedObject.getValue();
            System.out.println("Consumer Thread : "+x+":"+this.getName());
            count++;
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedObject sharedObject=new SharedObject();
        Producer producer1=new Producer(sharedObject);
        producer1.setName("p1");
        Producer producer2=new Producer(sharedObject);
        producer2.setName("p2");
        Consumer consumer1=new Consumer(sharedObject);
        consumer1.setName("C1");
        Consumer consumer2=new Consumer(sharedObject);
        consumer2.setName("C2");
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

    }
}

