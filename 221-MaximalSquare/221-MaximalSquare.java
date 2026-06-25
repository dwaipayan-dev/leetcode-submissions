// Last updated: 6/25/2026, 8:38:16 AM
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSqr = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    temp[i][j] = Math.min(Math.min(temp[i-1][j-1], 
                                    temp[i-1][j]), temp[i][j-1]) + 1;
                    maxSqr = Math.max(maxSqr, temp[i][j]);
                }
                    
            }
        }
        return maxSqr * maxSqr;
    }
}