// Last updated: 6/25/2026, 8:37:02 AM
class Solution {
    int m, n;
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (grid[r][c] == 1)
                    ans = Math.max(ans, bfs(grid, r, c));
        return ans;
    }
    int bfs(int[][] grid, int r, int c) {
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            ++ans;
            for (int i = 0; i < 4; i++) {
                int nr = top[0] + DIR[i], nc = top[1] + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] == 0) continue;
                grid[nr][nc] = 0; // Mark as visited
                q.offer(new int[]{nr, nc});
            }
        }
        return ans;
    }
}