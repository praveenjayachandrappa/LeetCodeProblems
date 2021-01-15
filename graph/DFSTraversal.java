package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {

   private int v;
    private List<LinkedList<Integer>> adjList;

    public  DFSTraversal(int v){
        this.v=v;
        adjList=new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<>());
        }
    }


    private void addEdage(int u,int v){
        adjList.get(u).add(v);
        /*adjList.get(v).add(u) */ //in case undirected graph
    }

    private void DFS_Recursive(){
        boolean[]  visited=new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i])
            dfs_recursive(i,visited);
        }

    }

    private void dfs_recursive(int v, boolean[] visited) {
        System.out.print(v+"->");
        visited[v]=true;
        for (int u:
             adjList.get(v)) {
            if(!visited[u])
                dfs_recursive(u,visited);
        }
    }

    private void DFS_Iterative(){
        boolean[] visited=new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
             dfs_Iterative(i,visited);
            }
        }

    }

    private void dfs_Iterative(int v, boolean[] visited) {
        Stack<Integer> stack=new Stack<>();
        stack.push(v);
        visited[v]=true;
        while (!stack.isEmpty()){
            Integer u = stack.pop();
            System.out.println(u);
            for (int x:
                 adjList.get(u)) {
                if(!visited[x]) {
                    stack.push(x);
                    visited[x] = true;
                }
            }
        }
    }

    public static void main(String[] args) {


        int v=5;

        DFSTraversal dfsTraversal=new DFSTraversal(v);

        dfsTraversal.addEdage(0,1);
        dfsTraversal.addEdage(0,3);
        dfsTraversal.addEdage(1,2);
        dfsTraversal.addEdage(3,2);
        dfsTraversal.addEdage(3,4);
       dfsTraversal.DFS_Recursive();
        dfsTraversal.DFS_Iterative();
    }
}
