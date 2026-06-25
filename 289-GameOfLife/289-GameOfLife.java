// Last updated: 6/25/2026, 8:37:56 AM
class Solution {
    public void gameOfLife(int[][] board) {
        int[] dirs = new int[]{-1, -1, 0, 1, 0, -1, 1, 1, -1};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveNeighbours = 0;
                for(int k = 0; k < dirs.length - 1; k++) {
                    int i0 = i + dirs[k];
                    int j0 = j + dirs[k+1];
                    if(i0 < 0 || i0 >= m || j0 < 0 || j0 >=n) continue;
                    if(board[i0][j0] % 2 == 1) liveNeighbours++;
                }
                if((liveNeighbours == 2 || liveNeighbours == 3) && board[i][j] == 1) {
                     board[i][j] += 2;
                }
                if(liveNeighbours == 3 && board[i][j] == 0) {
                    board[i][j] += 2;
                }
            }
        }

        for(int i= 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] /= 2;
            }
        }
    }
}