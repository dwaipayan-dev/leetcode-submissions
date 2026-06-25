// Last updated: 6/25/2026, 8:40:12 AM
class Solution {
    public boolean isValid(char[][] board, int i, int j, char c){
        int m = ((int)(i/3))*3;
        int n = ((int)(j/3))*3;
        for(int k = 0; k < 9; k++){
            if(board[i][k] == c || board[k][j] == c) return false;
        }
        for(int k = m; k < m+3; k++){
            for(int l = n; l < n+3; l++){
                if(board[k][l] == c){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(!Character.isDigit(board[i][j])){
                    for(int k = 1; k <= 9; k++){
                        char c = (char)('0' + k);
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}