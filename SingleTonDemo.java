import java.util.Arrays;
import java.util.GregorianCalendar;

public class SingleTonDemo {

    public static void main(String[] args) {
        System.out.println("SingletonDemo class");
        SingleTonPattern s1=SingleTonPattern.getSingleTon();
        SingleTonPattern s2=SingleTonPattern.getSingleTon();
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        try {
            s1.finalize();
            s2.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
