// Last updated: 6/25/2026, 8:37:16 AM
class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        if (m == 0) return mat;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
                if(mat[i][j]==0){
                    dist[i][j] = 0;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            for (int[] direction : DIRECTIONS) {
                int row = r+direction[0];
                int col = c+direction[1];
                if(row<0 || row>=m || col<0 || col>=n)
                    continue;
                if(dist[row][col] > dist[r][c]+1){
                    dist[row][col] = dist[r][c]+1;
                    queue.offer(new int[]{row,col});
                }
            }
        }
        return dist;
    }
}