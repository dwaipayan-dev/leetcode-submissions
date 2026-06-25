// Last updated: 6/25/2026, 8:36:56 AM
class Solution {
    public int djikstraUtils(Map<Integer, List<int[]>> graph, int source, int n){
        int[] visited = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source-1] = 0;
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j = 0; j < n; j++){
                if(visited[j] == 0 && dist[j] <= min){
                    min = dist[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = 1;
            int u = minIdx + 1;
            for(int[] vw: graph.get(u)){
                int v = vw[0];
                int w = vw[1];
                dist[v-1] = Math.min(dist[u-1] + w, dist[v-1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int d: dist){
            max = Math.max(max, d);
        }
        if(max == Integer.MAX_VALUE){
            return -1;
        }
        return max;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int t = 1; t <= n; t++){
            graph.put(t, new ArrayList<>());
        }
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            List<int[]> oldList = graph.get(u);
            oldList.add(new int[]{v, w});
        }
        return djikstraUtils(graph, k, n);
    }
}