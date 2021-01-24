package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDigonally {
    /**
     * Sort the matrix dignoally
     *
     * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
     *
     * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
     *
     *
     */


    public int[][] diagonalSort(int[][] mat) {

        int m=mat.length;
        int n=mat[0].length;


        //col :0

        //First I have to sort the columns keeping the row as same

        for(int c=0;c<n;c++){
            sort(mat,0,c,m,n);
        }


        //sort the rows from 1 keeping the column as same

        for(int row=1;row<m;row++){

            sort(mat,row,0,m,n);
        }


        return mat;
    }


    private void sort(int[][] mat,int row,int col,int m,int n){

        int r=row;
        int c=col;

        List<Integer> values=new ArrayList();
        while(r<m && c<n){
            values.add(mat[r][c]);
            r++;
            c++;
        }


        Collections.sort(values);


        //put it back to matrix since it is sorted

        r=row;
        c=col;

        int idx=0;
        while(r<m && c<n){
            mat[r][c]=values.get(idx++);
            r++;
            c++;
        }
/*
        //approach 2 using count sort 
        int[] values=new int[101];

        while(r<m && c<n){
            values[mat[r][c]]++;
            r++;
            c++;
        }
        r=row;
        c=col;
        for (int i = 0; i < 101; i++) {
            if(values[i]>0){
                int count=values[i];
                while (count-->0){
                    mat[r][c]=i;
                    r++;
                    c++;
                }
            }
        }*/
    }
}
