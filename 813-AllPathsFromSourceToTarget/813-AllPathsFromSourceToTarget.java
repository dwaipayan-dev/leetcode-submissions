// Last updated: 6/25/2026, 8:36:40 AM
class Solution {
    public void dfsUtils(int[][] graph, List<List<Integer>> allPaths,
    List<Integer> currentPath, int dest, int source){
        if(source == dest){
            //currentPath.add(source);
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            for(int v: graph[source]){
                currentPath.add(v);
                dfsUtils(graph, allPaths, currentPath, dest, v);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        dfsUtils(graph, allPaths, currentPath, graph.length - 1, 0);
        return allPaths;
    }
}