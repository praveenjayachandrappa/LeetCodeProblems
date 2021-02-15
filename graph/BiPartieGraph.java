package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BiPartieGraph {

    /***
     *
     * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
     *
     * There are no self-edges (graph[u] does not contain u).
     * There are no parallel edges (graph[u] does not contain duplicate values).
     * If v is in graph[u], then u is in graph[v] (the graph is undirected).
     * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
     * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
     *
     * Return true if and only if it is bipartite.
     */
     /*
    //DFS approach
    public boolean isBipartite(int[][] graph) {
        //using graph coloring
        TC->o(v+E)

        int n=graph.length;
        int[] colors=new int[n];

        for(int i=0;i<n;i++){

            if(colors[i]==0 && !dfs(graph,1,i,colors)) return false;
        }

        return true;
    }

    private boolean dfs(int[][] graph,int c,int node,int[] colors){

        if(colors[node]!=0){
          // return colors[node]==c;
             if(colors[node]==c)
                return true;
            else
                return false;
        }
        else{
            colors[node]=c;
        }

        for(int n:graph[node]){

            if(!dfs(graph,-c,n,colors))
                return false;
        }

        return true;
    }

    */
    //BFS approch:

    public boolean isBipartite(int[][] graph) {
        //using graph coloring
        //TC->o(v+E)

        int n=graph.length;
        int[] colors=new int[n];

        for(int i=0;i<n;i++){

            if(colors[i]==0){
                Queue<Integer> queue= new LinkedList<>()
                queue.add(i);
                colors[i]=1;
                while(!queue.isEmpty()){
                    Integer node=queue.poll();
                    for(int adj:graph[node]){

                        if(colors[node]==colors[adj])
                            return false;
                        else if(colors[adj]==0)
                        {
                            colors[adj]=-colors[node];
                            queue.add(adj);
                        }

                    }


                }



            }



        }

        return true;
    }
}
