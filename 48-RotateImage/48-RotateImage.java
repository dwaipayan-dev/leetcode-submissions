// Last updated: 6/25/2026, 8:39:58 AM
class Solution {
    public void rotate(int[][] matrix) {
        //Check transpose
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int t = matrix[i][j];
                //System.out.println(t);
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        
        //Reverse each row inplace
        for(int k = 0; k < matrix.length; k++){
            int start = 0;
            int end = matrix.length - 1;
            while(start < end){
                int temp = matrix[k][start];
                matrix[k][start] = matrix[k][end];
                matrix[k][end] = temp;
                start++;
                end--;
            }
        }
        
    }
}