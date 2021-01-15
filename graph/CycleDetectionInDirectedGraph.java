package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleDetectionInDirectedGraph {
    private int v;
    private List<LinkedList<Integer>> adjList;
    private  int time;
    public  CycleDetectionInDirectedGraph(int v){
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

    public boolean hasCycle(){
        int[] visited=new int[v];
        for (int i = 0; i < v; i++) {
            if(visited[i]==0 && dfs(i,visited,adjList))
                return true;
        }
        return false;
    }

    private boolean dfs(int v, int[] visited, List<LinkedList<Integer>> adjList) {
        visited[v]=1;
        for (int u:
             adjList.get(v)) {
         if(visited[u]==1) return true;

         if(visited[u]==0 && dfs(u,visited,adjList))
             return true;
        }
        visited[v]=2;
        return false;
    }


    public static void main(String[] args) {

        CycleDetectionInDirectedGraph graph=new CycleDetectionInDirectedGraph(6);
        graph.addEdage(0,1);
        graph.addEdage(0,3);
        graph.addEdage(1,2);
        graph.addEdage(3,5);
        graph.addEdage(3,4);
        graph.addEdage(0,4);
        boolean b = graph.hasCycle();
        System.out.println(b);
    }
}
