package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakListRowsInMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue(k, (o1, o2) -> {
            int[] arr1 = (int[]) o1;
            int[] arr2 = (int[]) o2;
            if(arr1[0]==arr2[0]){
                return arr1[1]-arr2[1];
            }
            else
            return arr1[0] - arr2[0];
        });

        for (int i = 0; i < m; i++) {
            int soldier = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    soldier += 1;
                else
                    break;
            }
            pq.add(new int[]{soldier, i});
        }

        int[] res = new int[k];
        int idx = 0;
        while (idx<k) {
            int[] row = pq.poll();
            res[idx] = row[1];
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] mat =
                {{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}
                };
        int k = 3;
        KWeakListRowsInMatrix obj = new KWeakListRowsInMatrix();
        int[] res = obj.kWeakestRows(mat, k);
        System.out.println(Arrays.toString(res));
    }
}
