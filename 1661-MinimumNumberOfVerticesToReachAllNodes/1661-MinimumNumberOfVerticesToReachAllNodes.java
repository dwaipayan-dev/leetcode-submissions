// Last updated: 6/25/2026, 8:36:15 AM
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] nodesWithInDegrees = new int[n];
        for(List<Integer> edge: edges) {
            nodesWithInDegrees[edge.get(1)]++;
        }

        List<Integer> ans = new ArrayList<>();

        // Our ans is nodes with no indegrees as they would not be reachable by other nodes
        for(int i = 0; i < n; i++) {
            if(nodesWithInDegrees[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}