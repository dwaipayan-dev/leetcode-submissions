// Last updated: 6/25/2026, 8:37:50 AM
class NumMatrix {
    int[][] temp;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int temp1[][] = new int[r+1][c+1];
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                temp1[i][j] = matrix[i-1][j-1] + temp1[i][j-1] 
                + temp1[i-1][j] - temp1[i-1][j-1];
            }
        }
        temp = temp1;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (temp[row2+1][col2+1] - temp[row2+1][col1] - 
        temp[row1][col2+1] + temp[row1][col1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */