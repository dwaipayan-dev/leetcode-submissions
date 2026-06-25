// Last updated: 6/25/2026, 8:32:44 AM
class Solution {
    public boolean isConnected(int x1, int y1, int r1, int x2, int y2, int r2){
        double euclideanDist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return (euclideanDist <= r1)?true:false;
    }
    
    public int BFSUtils(int source, Map<Integer, List<Integer>> graph, int nrow){
        int[] visited = new int[nrow];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = 1;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int i: graph.get(curr)){
                if(visited[i] == 0){
                    q.offer(i);
                    visited[i] = 1;
                }
            }
        }
        return count;
    }
    public int maximumDetonation(int[][] bombs) {
        int nrow = bombs.length;
        int ncol = bombs[0].length;
        //Construct a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < nrow; i++){
            graph.put(i, new LinkedList<Integer>());
            for(int j = 0; j < nrow; j++){
                if(i != j){
                    int x1 = bombs[i][0];
                    int y1 = bombs[i][1];
                    int r1 = bombs[i][2];
                    int x2 = bombs[j][0];
                    int y2 = bombs[j][1];
                    int r2 = bombs[j][2];
                    if(this.isConnected(x1, y1, r1, x2, y2, r2) == true){
                        graph.get(i).add(j);
                    }
                }
            }
        }
        //BFS taking each vertex as source
        int maxCount = 0;
        for(int i = 0; i < nrow; i++){
            int currCount = this.BFSUtils(i, graph, nrow);
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}