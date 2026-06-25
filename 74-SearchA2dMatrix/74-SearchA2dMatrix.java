// Last updated: 6/25/2026, 8:39:43 AM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Search row using column binary search
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m-1;
        int mid = 0;
        while(start < end){
            mid = (start + end)/2;
            if(matrix[mid][n-1] < target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        mid = start;
        start = 0;
        end = n-1;
        while(start <= end){
            int mid1 = (start + end)/2;
            if(matrix[mid][mid1] < target){
                start = mid1 + 1;
            } else if(matrix[mid][mid1] > target){
                end = mid1 - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}