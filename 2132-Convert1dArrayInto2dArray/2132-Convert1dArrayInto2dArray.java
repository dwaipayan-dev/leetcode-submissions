// Last updated: 6/25/2026, 8:32:46 AM
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int arrLength = original.length;
        if(m*n != arrLength) return new int[0][0];
        int[][] newMat = new int[m][n];
        for(int i = 0; i < arrLength; i++){
            newMat[i/n][i%n] = original[i];
        }
        return newMat;
    }
}