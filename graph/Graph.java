package graph;

import java.util.ArrayList;

public class Graph {

    static void addEdage(ArrayList<ArrayList<Integer>> adjMatrix,int u,int v){
        adjMatrix.get(u).add(v);
        adjMatrix.get(v).add(u);

    }
    static void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex: " + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

            int v=5;
        ArrayList<ArrayList<Integer>> adjMatrix=new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjMatrix.add(new ArrayList<>());
        }
            addEdage(adjMatrix,0,1);
            addEdage(adjMatrix,0,3);
            addEdage(adjMatrix,1,2);
            addEdage(adjMatrix,2,3);
            printGraph(adjMatrix);


        System.out.println("Negighours of vertex 2 ");

        for (Integer x:
             adjMatrix.get(1)) {
            System.out.print(x+" ");
        }
    }


    
}
