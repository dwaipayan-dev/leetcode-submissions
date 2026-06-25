// Last updated: 6/25/2026, 8:36:45 AM
class Solution {
    public boolean dfsUtils(int[][] graph, int u, int[] visited, int group) {
        visited[u] = group;
        int newGroup = (group%2) + 1;
        for(int v: graph[u]) {
            if(visited[v] != 0){
                if(visited[v] == group) return false;
            } else {
                if(dfsUtils(graph, v, visited, newGroup) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 1) return true;
        int[] visited = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == 0) {
                if(dfsUtils(graph, i,visited, 1) == false) return false;
            }
        }
        return true;
    }
}