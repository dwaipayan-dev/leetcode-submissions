// Last updated: 6/25/2026, 8:39:56 AM
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        final int m = matrix.length;
        final int n = matrix[0].length;
        int top = 0, left = 0, bottom = m-1, right = n-1;
        int state = 0;
        int r = 0, c = 0;
        if(n == 1){
            state = 1;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(state == 0){
                    spiral.add(matrix[r][c]);
                    c++;
                    if(c == right){
                        state = 1;
                        top++;
                        continue;
                    }
                }
                if(state == 1){
                    spiral.add(matrix[r][c]);
                    r++;
                    if(r == bottom){
                        state = 2;
                        right--;
                        continue;
                    }
                }
                if(state == 2){
                    spiral.add(matrix[r][c]);
                    c--;
                    if(c == left){
                        state = 3;
                        bottom--;
                        continue;
                    }
                }
                if(state == 3){
                    spiral.add(matrix[r][c]);
                    r--;
                    if(r == top){
                        state = 0;
                        left++;
                        continue;
                    }
                }
            }
        }
        return spiral;
    }
}