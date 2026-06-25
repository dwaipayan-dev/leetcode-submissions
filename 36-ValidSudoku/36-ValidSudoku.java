// Last updated: 6/25/2026, 8:40:13 AM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(Character.isDigit(board[i][j])){
                    for(int k = 0; k < 9; k++){
                        //Check row
                        if(j != k && board[i][k] == board[i][j]){
                            return false;
                        }
                        //Check col
                        if(i != k && board[k][j] == board[i][j]){
                            return false;
                        }
                    }
                    //Check subGrid
                    int subRowStart = i/3;
                    subRowStart *= 3;
                    int subColStart = j/3;
                    subColStart *= 3;
                    for(int l = subRowStart; l < subRowStart + 3; l++){
                        for(int m = subColStart; m < subColStart + 3; m++){
                            if(l != i && m != j && board[l][m] == board[i][j]){
                                return false;
                            }
                        }
                    }
                    
                }
            }
        }
        return true;
    }
}