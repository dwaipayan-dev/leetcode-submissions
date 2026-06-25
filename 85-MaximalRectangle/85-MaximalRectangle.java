// Last updated: 6/25/2026, 8:39:33 AM
class Solution {
    public int maxRectInHist(int[] hist){
        int maxRect = 0;
        Stack<Integer> maxHeightTop = new Stack<Integer>();
        int len = hist.length;
        for(int i = 0; i <= len; i++){
            int h = i == len? 0: hist[i];
            if(maxHeightTop.isEmpty() || hist[maxHeightTop.peek()] <= h){
                maxHeightTop.push(i);
            } else {
                int topElement = hist[maxHeightTop.pop()];
                maxRect = Math.max(maxRect, 
                topElement * (maxHeightTop.isEmpty()? i: i-maxHeightTop.peek() - 1));
                i--;
            }
        }
        return maxRect;
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxAreaRect = 0;
        int[][] matrixInt = new int[m+1][n];
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i-1][j] == '1'){
                    matrixInt[i][j] = matrixInt[i-1][j] + 1;
                } 
            }
            maxAreaRect = Math.max(maxAreaRect, maxRectInHist(matrixInt[i]));
        }
        return maxAreaRect;
    }
}