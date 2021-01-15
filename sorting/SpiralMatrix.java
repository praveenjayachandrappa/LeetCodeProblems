package sorting;

import java.util.Arrays;

public class SpiralMatrix {


    public static int[][] generateMatrix(int n) {

        int top=0,bottom=n-1;

        int left=0,right=n-1;

        int val=1;

        int[][] mat=new int[n][n];

        while(val<=n*n){
            for(int i=left;i<=right;i++){
                mat[top][i]=val;
                val++;
            }
            top++;

            for(int i=top;i<=bottom;i++){
                mat[i][right]=val;
                val++;
            }
            right--;

            for(int i=right;i>=left;i--){
                mat[bottom][i]=val;
                val++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                mat[i][left]=val;
                val++;
            }
            left++;
        }


        return mat;

    }

    public static void main(String[] args) {

        int n=3;

        int[][] matrix = generateMatrix(n);

        Arrays.stream(matrix).forEach(x-> System.out.println(Arrays.toString(x)));


    }
}
