package graph.newLearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoDFSTraversal {

    private int v;
    List<LinkedList<Integer>> adjList;

    DoDFSTraversal(int v){
        this.v=v;
        adjList=new ArrayList<>(v);
        for (int i = 0; i <v ; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int u,int v){
        adjList.get(u).add(v);
    }

    public void dfs(){
        boolean[] visited=new boolean[v];
        for (int i = 0; i <v ; i++) {
            dfs_recursive(i,visited);
        }
    }

    private void dfs_recursive(int v,boolean[] visited) {
        if(visited[v])
            return;
        System.out.print(v+" ");
        visited[v]=true;
        for (int x :adjList.get(v)) {
            dfs_recursive(x,visited);
        }
    }

    public static void main(String[] args) {

        /*int numberOfVertices=5;
        DoDFSTraversal dfsTraversal=new DoDFSTraversal(numberOfVertices);
        dfsTraversal.addEdge(0,1);
        dfsTraversal.addEdge(0,3);
        dfsTraversal.addEdge(1,2);
        dfsTraversal.addEdge(3,2);
        dfsTraversal.addEdge(3,4);
        dfsTraversal.dfs();
*/
        /*float a=2;
        float b=4;
        float i=a/b;
        int c=5;
        Float ddd = Float.valueOf(c);
        System.out.println(i);
        */

    /*    String res="0.3333333";
        String[] split = res.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        if(split[1].length()>1){
            stringBuilder.append("(");
            stringBuilder.append(split[1].charAt(0));
            stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }
        split[0]+=".";
        split[0]+=stringBuilder.toString();
        System.out.println(split[0]);
    */

        double a=0.142857143;
        long round = Math.round(a);
        System.out.println(round);
    }
}
