package graph;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * Printing all strongly connected components using kosaraju alogrithm
 *
 */
public class StronglyConnectedGraph {

    private int v;
    List<LinkedList<Integer>> adjList;

    public StronglyConnectedGraph(int v){
        this.v=v;
        adjList=new ArrayList<>(v);
        for (int i = 0; i <v ; i++) {
            adjList.add(new LinkedList<>());
        }
    }
    private void addEdge(int u,int v){
        adjList.get(u).add(v);  //directed graph
    }

    private  void SCC(){
        boolean[] visited=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < v; i++) {
            if(!visited[i])
                orderVertices(i,adjList,stack,visited); //toplogical sort for the given graph
        }
        //make all visited vertices as false
        for (int i = 0; i < v; i++) {
            visited[i]=false;
        }
        StronglyConnectedGraph reverseGraph=reverseGraph();
        while (!stack.isEmpty()){
            int v=stack.pop();
            if(!visited[v]) {
                dfs(v, reverseGraph.adjList, visited);
                System.out.println();
            }
        }

    }

    private void dfs(int u, List<LinkedList<Integer>> adjList, boolean[] visited) {
        visited[u]=true;
        System.out.print(u+" ");
        for (int v:
             adjList.get(u)) {
            if(!visited[v])
                dfs(v,adjList,visited);
        }
    }

    private StronglyConnectedGraph reverseGraph() {
        StronglyConnectedGraph graph = new StronglyConnectedGraph(v);
        for (int i = 0; i < v; i++) {
            for (int u : adjList.get(i)) {
                graph.adjList.get(u).add(i);
            }
        }
        return graph;
    }
    private void orderVertices(int u, List<LinkedList<Integer>> adjList, Stack<Integer> stack, boolean[] visited) {
        visited[u]=true;
        //look at its negibhours of u
        for (int v:
             adjList.get(u)) {
            if(!visited[v])
                orderVertices(v,adjList,stack,visited);
        }
        stack.push(u);
    }


    public static void main(String[] args) {
        StronglyConnectedGraph G = new StronglyConnectedGraph(9);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(3,0);
        G.addEdge(2,4);
        G.addEdge(4,5);
        G.addEdge(5,6);
        G.addEdge(6,4);
        G.addEdge(7,6);
        G.addEdge(7,8);
        G.SCC();

        Deque<Integer> queue=new LinkedList<>();

        ArrayList<Integer> list=new ArrayList<>();

    }
}
