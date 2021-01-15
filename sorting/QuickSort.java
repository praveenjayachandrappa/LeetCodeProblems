package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] A={9,6,5,0,8,2,4,7};


        int[] sort = quickSort(A, 0, A.length - 1);
        System.out.println("Sorted Array using QuickSort Algorithm is : "+ Arrays.toString(sort));
    }

    private static int[] quickSort(int[] A, int low, int high) {

        if (low<high) {
            int p=parition(A,low,high);
            quickSort(A, low, p-1);
            quickSort(A, p+1, high);
        }
        return A;
    }

    private static int parition(int[] A, int low, int high) {
        int last=A[high];
        int i=low-1;
        for (int j = low; j <high; j++) {
            if(A[j]<=last){
                i+=1;
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
        int temp=A[i+1];
        A[i+1]=last;
        A[high]=temp;

        return i+1;
    }

}
