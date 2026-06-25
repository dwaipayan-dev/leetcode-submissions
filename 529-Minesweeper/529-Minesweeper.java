// Last updated: 6/25/2026, 8:37:17 AM
class Solution {
    public void DFSUtils(int i, int j, int[][] visited, char[][] board){
        visited[i][j] = 1;
        int[] direction = { -1, -1, 1, 1, -1, 0, 1, 0, -1};
        int count = 0;
        for(int l = 0; l < direction.length -1; l++){
            int r = i + direction[l];
            int c = j + direction[l+1];
            if(r < 0 || r >= board.length || c < 0 || c >= board[0].length){
                continue;
            } else {
                if(board[r][c] == 'M'){
                        count++;
                }
            }
        }
        if(count == 0){
            board[i][j] = 'B';
        } else{
            board[i][j] = (char)(count + '0');
        }
        for(int k = 0; k < direction.length - 1; k++){
            int r = i + direction[k];
            int c = j + direction[k+1];
            //Invalid coords
            if(r < 0 || r >= board.length || c < 0 || c >= board[0].length){
                continue;
            } else{
                if(visited[r][c] == 0){
                    if(board[r][c] == 'E' && board[i][j] == 'B'){
                        DFSUtils(r, c, visited, board);
                    }
                }
            }
        }
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        //click is a length 2 array
        int r = click[0];
        int c = click[1];
        int nrow = board.length;
        int ncol = board[0].length;
        int[][] visited = new int[nrow][ncol];
        if(board[r][c] == 'M'){
            board[r][c] = 'X';
            return board;
        }
        else if(board[r][c] == 'E'){
            this.DFSUtils(r, c, visited, board);   
        }
        return board;
    }
}