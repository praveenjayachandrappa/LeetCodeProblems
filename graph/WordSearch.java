package graph;

public class WordSearch {

    //using Extra space
        public boolean exist(char[][] board, String word) {

            int m=board.length;
            int n=board[0].length;

            boolean[][] visited=new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==word.charAt(0) && search(board,i,j,word,0,visited))
                        return true;
                }
            }

            return false;
        }

        private boolean search(char[][] board,int i,int j,String word,int idx,boolean[][] visited){

            visited[i][j]=true;
            if(idx>=word.length()-1)
                return true;

            if(i>0 && !visited[i-1][j] && board[i-1][j]==word.charAt(idx+1) && search(board,i-1,j,word,idx+1,visited))
                return true;

            if(j>0 && !visited[i][j-1] && board[i][j-1]==word.charAt(idx+1) && search(board,i,j-1,word,idx+1,visited))
                return true;

            if(i<board.length-1 && !visited[i+1][j] && board[i+1][j]==word.charAt(idx+1) && search(board,i+1,j,word,idx+1,visited))
                return true;

            if(j<board[0].length-1 && !visited[i][j+1] && board[i][j+1]==word.charAt(idx+1) && search(board,i,j+1,word,idx+1,visited))
                return true;

            visited[i][j]=false;
            return false;

        }


    public static void main(String[] args) {



       char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
       String word="SEE";

       WordSearch wordSearch=new WordSearch();

        boolean exist = wordSearch.exist(board, word);

        System.out.println(exist);
    }
    }

