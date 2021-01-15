import java.util.*;

public class SearchElementInTwoDGrid {


    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) {
            return false;
        }

        //helper - findRow() search through just the first num of each row
        //if target is less than first then
        int row = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (target == matrix[i][0] ) {
                return true;
            } else if (target >= matrix[i][0] ) {
                row = i;
            }
        }

        for (int i = 0; i < matrix[row].length; i++) {
            if (target == matrix[row][i]) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {


/*
       int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;

        boolean res = searchMatrix(matrix, target);

        System.out.println(res);


        List<Integer> list=new ArrayList<>();
*/
/*
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add();*//*
*/


        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        String string = set.toString();
        System.out.println(string);

        StringBuilder sb = new StringBuilder();



    }

}
