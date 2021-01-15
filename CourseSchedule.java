import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //when there are no prerequisites ,I can take course from n-1 to 0;
        if(prerequisites.length==0){
            int[] arr=new int[numCourses];
            int j=0;
            for(int i=numCourses-1;i>=0;i--)
                arr[j++]=i;
            return arr;

        }

        //Building adjacency List
        List<LinkedList<Integer>> adjList=new ArrayList(numCourses);
        for(int i=0;i<numCourses;i++){
            adjList.add(new LinkedList());

        }
        for(int[] pair:prerequisites){
            //u should come before v while ordering
            int u=pair[0];
            int v=pair[1];
            adjList.get(u).add(v);
        }
        //check if the DAG contains cycle
        //no topological sort exits if DAG contains the cycle
        if(hasCycle(adjList,numCourses)) return new int[0];


        //doing topological sorting
        Stack<Integer> stack=new Stack();
        boolean[] visited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
                doTopologicalSort(i,adjList,visited,stack);
        }

        int[] res=new int[numCourses];
        int i=res.length-1;
        while(!stack.isEmpty()){
            res[i--]=stack.pop();
        }

        return res;

    }



    private void doTopologicalSort(int u,List<LinkedList<Integer>> adjList,boolean[] visited,Stack<Integer> stack){
        visited[u]=true;
        for(int v:adjList.get(u)){
            if(!visited[v])
                doTopologicalSort(v,adjList,visited,stack);
        }
        stack.push(u);
    }


    private boolean hasCycle(List<LinkedList<Integer>> adjList, int n){
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            //if cycle exits in the graph
            if(visited[i]==0 && dfs(i,adjList,visited)) return true;
        }

        return false; //no cycle exits in the DAG
    }

    private boolean dfs(int u, List<LinkedList<Integer>> adjList, int[] visited){

        visited[u]=1; //being explored

        for(int v:adjList.get(u)){

            if(visited[v]==1) return true;

            if(visited[v]==0 && dfs(v,adjList,visited)) return true;

        }
        //vertex is completely explored
        visited[u]=2;
        return false;

    }

    public static void main(String[] args) {
        String s="A,B,C,D";

        String[] split = s.split(",");

        for (String x:split) {
            System.out.println(x);
        }
    }
}
