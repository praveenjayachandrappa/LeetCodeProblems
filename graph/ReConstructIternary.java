package graph;

import java.util.*;
import java.util.concurrent.RecursiveAction;

/**
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 *
 * Leet code problem  NO : 332
 *
 */

public class ReConstructIternary {
    private class City implements  Comparable{
        private String name;
    public City(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Object o) {
            City city=(City)o;
            return this.name.compareTo(city.getName());
        }
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result=new ArrayList<>();

        Map<String,LinkedList<City>> adjList=new HashMap<>();

        for (List<String> list:
             tickets) {
            //I get one list object
            if(adjList.get(list.get(0))==null){
                LinkedList<City> adj=new LinkedList<>();
                adj.add(new City(list.get(1)));
                adjList.put(list.get(0),adj);
            }
            else{
                LinkedList<City> cities = adjList.get(list.get(0));
                cities.add(new City(list.get(1)));
                adjList.put(list.get(0),cities);
            }
        }

        dfs(adjList,"JFK",result);

        return result;
    }

    private void dfs(Map<String, LinkedList<City>> adjList, String start, List<String> result) {
        result.add(start);
        for (City city:
             adjList.get(start)) {
            adjList.get(start).remove(city);
            dfs(adjList,city.getName(),result);
        }
    }

    public static void main(String[] args) {
        //String[][] strings= {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        ArrayList<String> list1 =new ArrayList<>();
        list1.add("JFK");
        list1.add("SFO");
        ArrayList<String> list2 =new ArrayList<>();
        list1.add("JFK");
        list1.add("ATL");
        ArrayList<String> list3 =new ArrayList<>();
        list1.add("SFO");
        list1.add("ATL");
        ArrayList<String> list4 =new ArrayList<>();
        list1.add("ATL");
        list1.add("JFK");
        ArrayList<String> list5 =new ArrayList<>();
        list1.add("ATL");
        list1.add("SFO");

        List<List<String>> inputList=new ArrayList<>();
        inputList.add(list1);
        inputList.add(list2);
        inputList.add(list3);
        inputList.add(list4);
        inputList.add(list5);

        ReConstructIternary obj=new ReConstructIternary();
        List<String> itinerary = obj.findItinerary(inputList);
        System.out.println(itinerary);
    }

}
