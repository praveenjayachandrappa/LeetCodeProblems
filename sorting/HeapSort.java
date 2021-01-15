package sorting;

import java.util.Arrays;

public class HeapSort {

    //program for Heap Sort

    //Heap is complete binary tree
    //Alogritm create a heap


    public void heapSort(int[] A,int n){
        createHeap(A,n);
        System.out.println(Arrays.toString(A));
        for (int i = n-1; i >1; i--) {
            deleteHeap(A,i);
        }
    }

    public void createHeap(int[] A,int n){
        for (int i = 2; i <n ; i++) {
            insertHeap(A, i);
        }
    }

    public void deleteHeap(int[] A,int n){
        int x=A[1];
        //copy the last element to the first in heap
        A[1]=A[n];
        //start adjusting heap
        int i=1;
        int j=2*i;
        while (j<n-1){
            //compare with its children
            if(A[j+1]>A[j]) {
                j = j + 1;
            }
            //if any children is greater than its parent then swap it
            if(A[j]>A[i]){
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;
                i=j;
                j=2*j;
            }
            else{
                break;
            }
        }
        A[n]=x;
    }

    private void insertHeap(int[] A, int i) {
        int temp=A[i];
        while (i>1 && temp>A[i/2]){
            A[i]=A[i/2];
            i=i/2;
        }
        A[i]=temp;
    }


    public static void main(String[] args) {

        int[] A={0,9,4,3,22,19,16,32,41,13,5,-8};
        int n=A.length;
        HeapSort heapSort=new HeapSort();
        heapSort.heapSort(A,A.length);
        System.out.println(Arrays.toString(A));
    }
}
