// Last updated: 6/25/2026, 8:37:10 AM
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c){
            return mat;
        }
        int[][] newMat = new int[r][c];
        for(int i =0; i < m*n; i++){
            newMat[i/c][i%c] = mat[i/n][i%n];
        }
        return newMat;
    }
}