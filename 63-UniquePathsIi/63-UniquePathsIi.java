// Last updated: 6/25/2026, 8:39:50 AM
class Solution {
    public int dpUtils(int[][] temp, int m, int n, int[][] obstacleGrid){
        if(m == 0 && n == 0 && obstacleGrid[m][n] == 0) return 1;
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1) return 0;
        if(temp[m][n] != -1) return temp[m][n];
        temp[m][n] = dpUtils(temp, m-1, n, obstacleGrid) + dpUtils(temp, m, n-1, obstacleGrid);
        return temp[m][n];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] temp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = -1;
            }
        }
        return dpUtils(temp, m-1, n-1, obstacleGrid);
    }
}