import java.util.PriorityQueue;

public class KthFactor {

    public static int kthFactor(int n, int k) {
        if(k==1)
            return 1;
        int count=1;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                count++;
            }
            if(count==k)
                return i;
        }
        System.out.println(count);
        return -1;
    }

    public static void main(String[] args) {


        int k=4;
        int n=4;
        int kthFactor = kthFactor(n, k);

        System.out.println(kthFactor);

    }
}
