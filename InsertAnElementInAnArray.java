import java.util.Arrays;

public class InsertAnElementInAnArray {


    private static void insertElement(int[] arr,int index,int element){
        for (int i = 5; i>=index ; i--) {
            arr[i+1]=arr[i];
        }
        arr[index]=element;
    }

    private static int deleteATIndex(int[] arr,int index){
        int deleltedElement=arr[index];
        int i=index;
        while (i<arr.length-1){
            if(arr[i]==0)
                break;
            arr[i]=arr[i+1];
            i++;
        }
        arr[i]=0;
        return deleltedElement;
    }
    public static void main(String[] args) {

        int[] arr=new int[6];
        arr[0]=5;
        arr[1]=9;
        arr[2]=6;
        arr[3]=10;
        arr[4]=12;
        arr[5]=7;

    /*    int index=2;
        int element=15;
        insertElement(arr,index,element);
        insertElement(arr,2,13);
        insertElement(arr,4,11);
        insertElement(arr,arr.length-1,22);
        insertElement(arr,arr.length-2,31);
        insertElement(arr,arr.length-3,43);
        insertElement(arr,arr.length-1,66);
        System.out.println(Arrays.toString(arr));
        System.out.println(deleteATIndex(arr,3)+": "+Arrays.toString(arr));
        System.out.println(deleteATIndex(arr,0 )+": "+Arrays.toString(arr));
        System.out.println(deleteATIndex(arr,1 )+": "+Arrays.toString(arr));
    */

    //Increasing the size of an array

        System.out.println(arr.length);

        int[] copyA=new int[2*arr.length];
        for (int i = 0; i <arr.length ; i++) {
            copyA[i]=arr[i];
        }
        arr=copyA;
        System.out.println(Arrays.toString(arr)+": length is "+arr.length);

    }

}
