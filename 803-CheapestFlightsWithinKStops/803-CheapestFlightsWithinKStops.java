// Last updated: 6/25/2026, 8:36:42 AM
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	    int[] dist = new int[n];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[src] = 0;
        // We'll use modified Bellman Ford with lazy update, where we will only update the distances after going over all flights
        // This will ensure we only update till ith stop in each iteration
        for(int i = 0; i < k+1; i++) {
            int[] temp = dist.clone();
            for(int[] flight: flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]){
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        // If final distance is Inf, dest is not reachable within k stops so return -1
        return dist[dst] == Integer.MAX_VALUE ? -1: dist[dst];
    }
}