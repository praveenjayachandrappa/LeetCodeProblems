package graph;

import java.util.*;


public class ChepeastFlights {
        private class Flight{
            int dist;
            int src;
            int hobs;
            Flight(int dist,int src,int hobs){
                this.dist=dist;
                this.src=src;
                this.hobs=hobs;
            }

            public int getDist() {
                return dist;
            }

            public int getSrc() {
                return src;
            }

            public int getHobs() {
                return hobs;
            }
        }

        private class Pair{

            private   int dst;
            private int price;
            Pair(int dst,int price){
                this.dst=dst;
                this.price=price;
            }

            public int getDst() {
                return dst;
            }

            public int getPrice() {
                return price;
            }
        }
    public  int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<LinkedList<Pair>> adjList=new ArrayList<>(n); //n ciites

        for (int i = 0; i < n; i++) {
            adjList.add(new LinkedList<Pair>());
        }
        for (int[] flight:
             flights) {
            int s=flight[0];
            int d=flight[1];
            int pr=flight[2];
            adjList.get(s).add(new Pair(d,pr));
        }
        PriorityQueue<Flight> pq = new PriorityQueue<>((f1, f2) -> f1.getDist()-f2.getDist());
        pq.add(new Flight(0,src,K+1));
        while (!pq.isEmpty()){
            Flight flight = pq.poll();
            int distance=flight.getDist();
            int u=flight.getSrc();
            int e=flight.getHobs();
            if(u==dst) return distance;
            if (e>0){
                LinkedList<Pair> pairs = adjList.get(u);
                for (Pair pair:
                     pairs) {
                    pq.add(new Flight(distance+pair.getPrice(), pair.getDst(), e-1));
                }
            }
        }
            return -1;
    }


    public static void main(String[] args) {

        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int source = 0;
        int dst = 2;
        int k = 1; //k stops
        ChepeastFlights flights1 = new ChepeastFlights();
        int cheapestPrice = flights1.findCheapestPrice(n, flights, source, dst, k);
        System.out.println(cheapestPrice);

    }
}



