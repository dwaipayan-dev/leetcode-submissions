// Last updated: 6/25/2026, 8:36:35 AM
class Solution {
    public int dpUtils(int[][] matrix, int[][] temp, int i, int j){
        if(j == 0 || j >= temp[0].length) return Integer.MAX_VALUE;
        if(i == 0) return 0;
        if(temp[i][j] != -1) return temp[i][j];
        temp[i][j] = matrix[i-1][j-1] + Math.min(Math.min(dpUtils(matrix, temp, i-1, j-1), dpUtils(matrix, temp, i-1, j)), dpUtils(matrix, temp, i-1, j+1));
        return temp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                temp[i][j] = -1;
            }
        }
        int minPath = Integer.MAX_VALUE;
        for(int j = 1; j <= n; j++){
            minPath = Math.min(minPath, dpUtils(matrix, temp, m, j));
        }
        return minPath;
    }
}