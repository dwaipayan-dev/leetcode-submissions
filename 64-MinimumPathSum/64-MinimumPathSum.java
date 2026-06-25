// Last updated: 6/25/2026, 8:39:47 AM
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m+1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1) {
                    temp[i][j] = grid[i-1][j-1];
                }
                else {
                    if(i - 1 == 0) {
                        temp[i-1][j] = Integer.MAX_VALUE;
                    }
                    if(j - 1 == 0) {
                        temp[i][j-1] = Integer.MAX_VALUE;
                    }
                    temp[i][j] = grid[i-1][j-1] + Math.min(temp[i-1][j], temp[i][j-1]);
                }
                
            }
        }
        // for(int i = 0; i <= m; i++) {
        //     System.out.println(Arrays.toString(temp[i]));
        // }
        return temp[m][n];
    }
}