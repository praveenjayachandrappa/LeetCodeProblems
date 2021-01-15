import javax.crypto.spec.PSource;
import java.util.Arrays;

public class SortArrayInDescendingOrder {

    public int[] sortIndescending(int[] arr){

        Arrays.sort(arr);
        reverse(arr);
        return arr;
    }

    private void reverse(int[] arr) {
        int f=0,r=arr.length-1;
        while (f<=r){
            int temp=arr[f];
            arr[f]=arr[r];
            arr[r]=temp;
            r--;
            f++;
        }
    }

    public static void main(String[] args) {

        int[] arr={3,6,7,8,4,10,11};
        System.out.println(Arrays.toString(new SortArrayInDescendingOrder().sortIndescending(arr)));
    }
}
