import java.util.LinkedList;
import java.util.Queue;

/**
    Lettcode problem statement :
 In a given grid, each cell can have one of three values:

 the value 0 representing an empty cell;
 the value 1 representing a fresh orange;
 the value 2 representing a rotten orange.
 Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

 Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 *
 *
 */
class  Pair {
    int r;
    int c;
    Pair(int r,int c) {
        this.r=r;
        this.c=c;
    }
}
public class RottingOragnes{


    public int orangesRotting(int[][] grid) {
        int freshOrange = 0;
        int time=0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        
        while (!queue.isEmpty()){
            int nums=queue.size();
            for (int i = 0; i < nums; i++) {
                Pair p=queue.poll();
                int r=p.r;
                int c=p.c;
                if (r > 0 && grid[r - 1][c] == 1) {
                    queue.add(new Pair(r - 1, c));
                    freshOrange--;
                    grid[r - 1][c] = 2;
                }
                if (r < grid.length - 1 && grid[r + 1][c] == 1) {
                    queue.add(new Pair(r + 1, c));
                    freshOrange--;
                    grid[r + 1][c] = 2;
                }
                if (c > 0 && grid[r][c - 1] == 1) {
                    queue.add(new Pair(r, c - 1));
                    freshOrange--;
                    grid[r][c - 1] = 2;
                }
                if (c < grid[0].length - 1 && grid[r][c + 1] == 1) {
                    queue.add(new Pair(r, c + 1));
                    freshOrange--;
                    grid[r][c + 1] =2;
                }
            }
            if(!queue.isEmpty())
                time++;
        }
        return freshOrange==0?time:-1;
    }

    public static void main(String[] args) {

        int[][] grid={
                {2,1,1,},
                {1,1,0},
                {0,1,1}
        };
        RottingOragnes rottingOragnes=new RottingOragnes();
        int res = rottingOragnes.orangesRotting(grid);
        System.out.println(res);
        }
}