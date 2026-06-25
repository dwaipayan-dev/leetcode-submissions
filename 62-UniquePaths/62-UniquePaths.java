// Last updated: 6/25/2026, 8:39:51 AM
class Solution {
    public int dpUtils(int[][] temp, int m, int n){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0) return 0;

        if(temp[m][n] != -1){
            return temp[m][n];
        }
        temp[m][n] = dpUtils(temp, m-1, n) + dpUtils(temp, m, n-1);
        return temp[m][n];
    }
    public int uniquePaths(int m, int n) {
        int[][] temp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = -1;
            }
        }
        return dpUtils(temp, m-1, n-1);
    }
}