package graph;

import sun.awt.image.ImageWatched;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortingforDAG {
    private int v;
    private List<LinkedList<Integer>> adjList;

    public TopologicalSortingforDAG(int v){
        this.v=v;
        adjList=new ArrayList<>(v);
        for (int i = 0; i <v ; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    private void addEdge(int u,int v){
        adjList.get(u).add(v);
    }

    public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + "->");
            for (int x : adjList.get(i)) {
                System.out.print(x + "->");
            }
            System.out.println();
        }

    }

        private void doTopologicalSorting(){

                boolean[] visited=new boolean[v];
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i <v ; i++) {
                if(!visited[i])
                dfs_rec(i,adjList,visited,stack);
            }
            System.out.print("Topological sort for the grap is : ");
            while (!stack.isEmpty()){
                System.out.print(stack.pop()+"->");
            }

        }

    private void dfs_rec(int u, List<LinkedList<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[u]=true;
        for (int v: adjList.get(u)) {
            if(!visited[v]){
                dfs_rec(v,adjList,visited,stack);
            }
        }
        stack.push(u);
    }


    public static void main(String[] args) {

        TopologicalSortingforDAG dag = new TopologicalSortingforDAG(5);

        dag.addEdge(0,1);
        dag.addEdge(0,3);
        dag.addEdge(0,4);
        dag.addEdge(1,2);
        dag.addEdge(3,4);
        dag.addEdge(4,2);

        //dag.printGraph();

        dag.doTopologicalSorting();
    }

}
