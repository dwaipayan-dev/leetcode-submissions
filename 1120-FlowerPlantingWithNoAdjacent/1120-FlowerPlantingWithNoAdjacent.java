// Last updated: 6/25/2026, 8:36:24 AM
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < paths.length;i++){
            int u = paths[i][0] - 1;
            int v = paths[i][1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] colorRes = new int[n];
        for(int i = 0; i < n; i++){
            int[] color = new int[5];
            for(int j: graph.get(i)){
                color[colorRes[j]] = 1;
            }
            for(int k = 4; k > 0; k--){
                if(color[k] != 1){
                    colorRes[i] = k;
                } 
            }
        }
        return colorRes;
    }
}