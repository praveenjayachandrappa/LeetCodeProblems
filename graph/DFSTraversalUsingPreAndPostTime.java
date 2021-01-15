package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS Traversal using pre & post time & it will be useful in dfs to find topological sorting
 */
public class DFSTraversalUsingPreAndPostTime {

    private int v;
    private List<LinkedList<Integer>> adjList;
    private  int time;
    public  DFSTraversalUsingPreAndPostTime(int v){
        this.v=v;
        adjList=new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<>());
        }
        this.time=0;
    }

    private void addEdage(int u,int v){
        adjList.get(u).add(v);
        /*adjList.get(v).add(u) */ //in case undirected graph
    }

    public static void main(String[] args) {

        int v=5;

        DFSTraversalUsingPreAndPostTime dfsTraversal=new DFSTraversalUsingPreAndPostTime(v);

        dfsTraversal.addEdage(0,1);
        dfsTraversal.addEdage(0,3);
        dfsTraversal.addEdage(1,2);
        dfsTraversal.addEdage(3,2);
        dfsTraversal.addEdage(3,4);
         dfsTraversal.DFS_Recursive();
      //  dfsTraversal.DFS_Iterative();

    }

    private void DFS_Recursive() {
        boolean[] visited=new boolean[v];
        int[] pre=new int[v];
        int[] post=new int[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i])
                dfs(i,visited,adjList,pre,post);
        }

        for (int i = 0; i <v ; i++) {
            System.out.println(i+"->"+pre[i]+","+post[i]);
        }
    }

    private void dfs(int v, boolean[] visited, List<LinkedList<Integer>> adjList, int[] pre, int[] post) {
        visited[v]=true;
        pre[v]=time++;
        System.out.println(v);
        for (int u: adjList.get(v)) {
            if(!visited[u])
            dfs(u,visited,adjList,pre,post);
        }
        post[v]=time++;
    }
}
