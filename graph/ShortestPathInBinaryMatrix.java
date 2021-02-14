package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    /** Shortest Path in Binary Matrix
     *
     * In an N by N square grid, each cell is either empty (0) or blocked (1).
     *
     * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
     *
     * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
     * C_1 is at location (0, 0) (ie. has value grid[0][0])
     * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
     * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
     * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: [[0,1],[1,0]]
     *
     *
     * Output: 2
     *
     * Example 2:
     *
     * Input: [[0,0,0],[1,1,0],[1,1,0]]
     *
     *
     * Output: 4
     *
     *
     *
     * Note:
     *
     * 1 <= grid.length == grid[0].length <= 100
     * grid[r][c] is 0 or 1
     * @param grid
     * @return
     */

    //This is problem is solved using bfs traversal
    //Time complexity : o(mn)
    //Space Complexity :o(mn);
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0]==1)
            return -1;
        int m=grid.length;

        int n=grid[0].length;

        int[][] dir={{0,-1},{0,1},{-1,0},{1,0},{1,-1},{1,1},{-1,1},{-1,-1}};
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,1});
        grid[0][0]=1;

        while(!queue.isEmpty()){

            int size=queue.size();

            while(size-->0){
                int[] point=queue.poll();

                if(point[0]==m-1 && point[1]==n-1)
                    return point[2];

                for(int[] d:dir){
                    int r=point[0]+d[0];
                    int c=point[1]+d[1];
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==0){
                        queue.add(new int[]{r,c,point[2]+1});
                        grid[r][c]=1;
                    }

                }

            }
        }


        return -1;

    }
}
