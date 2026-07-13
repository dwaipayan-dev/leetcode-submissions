// Last updated: 7/13/2026, 8:20:47 AM
/*
 * I made a mistake, i used current iterations u + d to calculate v. Essentially allowing intermediate stops.
 * 
 * There are 2 main points in this question:
 * 
 * 1. Modified bellman ford upto K + 1 iterations
 * 2. Only use previous iteration data to calculate new iteration so it allows 1 flight per iteration
*/

1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        int[] dist = new int[n];
4        Arrays.fill(dist, Integer.MAX_VALUE);
5        dist[src] = 0;
6        // Bellman ford upto k + 1
7        for(int i = 0; i <= k; i++) {
8            int[] w = dist.clone();
9            for(int[] flight: flights) {
10                int u = flight[0];
11                int v = flight[1];
12                int d = flight[2];
13                if(dist[u] != Integer.MAX_VALUE && w[v] > dist[u] + d ){
14                    w[v] = dist[u] + d;
15                }
16            }
17            dist = w;
18        }
19
20        return dist[dst] == Integer.MAX_VALUE ? -1: dist[dst];
21    }
22}