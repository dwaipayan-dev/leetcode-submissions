// Last updated: 6/25/2026, 8:38:03 AM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        for(int j = 0; j < matrix[0].length; j++) {
            while(i > 0 && matrix[i][j] > target) {
                i--;
            }
            if(i < 0) return false;
            if(matrix[i][j] == target) return true;
        }
        return false;
    }
}