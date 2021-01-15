package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectingCycleInUndirectedGraph {

   private int v;
    private List<LinkedList<Integer>> adjList;

    DetectingCycleInUndirectedGraph(int v){
        this.v=v;
        adjList=new ArrayList<>(v);
        for (int i = 0; i <v ; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    private void addEdge(int u,int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u); //undirected graph
    }

    public boolean hasCycle_DFS(){
        boolean[] visited=new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i] && hasCycle_rec(i,adjList,visited,-1))
                return true;
        }

        return false;
    }

    private boolean hasCycle_rec(int u, List<LinkedList<Integer>> adjList, boolean[] visited, int parent) {
        visited[u]=true;
        for (int v:
             adjList.get(u)) {
            if(visited[v]==true && v!=parent) return true;
            if(!visited[v] && hasCycle_rec(v,adjList,visited,u)) return true;
        }

        return false;
    }


    public static void main(String[] args) {

        DetectingCycleInUndirectedGraph graph=new DetectingCycleInUndirectedGraph(5);
        /*graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(3,4);*/

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        //graph.addEdge(4,0);

        boolean b = graph.hasCycle_DFS();


        System.out.println(b);
    }




}
