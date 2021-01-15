package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrix {


    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u,int v){
        adjList.get(u).add(v);
    }

    private static void printadjList(ArrayList<ArrayList<Integer>> adjList,int v){

        for (int i = 0; i <v ; i++) {
            ArrayList<Integer> list = adjList.get(i);
            System.out.println(i+"->"+list.toString());
        }
    }


    public static void main(String[] args) {
/*
        int v=5;

        int[][] adjMatrix=new int[v][v];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.println("Is there any edge between : "+i+"->"+j);
                adjMatrix[i][j]= scanner.nextInt();
            }
        }
        Arrays.stream(adjMatrix).forEach(arr->System.out.println(Arrays.toString(arr)));*/

            int v=5;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>(v);

        for (int i = 0; i <v ; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        addEdge(adjList,0,1);
        addEdge(adjList,0,3);
        addEdge(adjList,1,2);
        addEdge(adjList,3,1);
        addEdge(adjList,3,4);
        printadjList(adjList,v);

    }
}
