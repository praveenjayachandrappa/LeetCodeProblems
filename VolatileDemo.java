import sun.awt.windows.ThemeReader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class VolatileDemo  extends  Thread {

    boolean isFlag = true;

    @Override
    public void run() {
        int count = 0;
        if (isFlag) {
            count++;
        }
        System.out.println("Thread terminated is : " + count);

    }

    public static void main(String[] args) throws InterruptedException {
/*

        VolatileDemo myThread=new VolatileDemo();
        myThread.start();

        System.out.println( Thread.currentThread());
        Thread.sleep(10000);
        Thread.currentThread();
        myThread.join();

        System.out.println("Working set to "+myThread.isFlag);

*/
/*

        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        map.put("abc", "praveen");
        map.put("andy", "bob");
        map.put(null, "xyz");
        map.put(null, "lmn");
*/

        /*
        Set<String> set = map.keySet();

        synchronized (map){
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                iterator.
                System.out.println(iterator.next()+": "+ map.get(iterator.next()));
            }
        }*/
/*

        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
*/


        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null, "bac");

        for (String key : concurrentHashMap.keySet()) {
            System.out.println(key + " " + concurrentHashMap.get(key));
        }

    }
}