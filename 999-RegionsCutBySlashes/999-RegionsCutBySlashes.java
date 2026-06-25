// Last updated: 6/25/2026, 8:36:34 AM
class Solution {
    public void dfsUtils(int[][] temp, int i, int j){
        int[] directions = {-1, 0, 1, 0, -1};
        for(int d = 0; d < directions.length -1; d++){
            int r = i + directions[d];
            int c = j + directions[d+1];
            if(r < 0 || r >= temp.length || c < 0 || c >= temp.length) continue;
            if(temp[r][c] == 0){
                temp[r][c] = 2;
                dfsUtils(temp, r, c);
            }
        }
    }
    public int regionsBySlashes(String[] grid) {
        int[][] temp = new int[3*grid.length][3*grid.length];
        for(int i = 0; i < grid.length; i++){
            char[] t = grid[i].toCharArray();
            for(int j = 0; j < t.length; j++){
                int r = i*3;
                int c = j*3;
                if(t[j] == '/'){
                    temp[r+2][c] = 1;
                    temp[r+1][c+1] = 1;
                    temp[r][c+2] = 1;
                } 
                if(t[j] == '\\'){
                    temp[r][c] = 1;
                    temp[r+1][c+1] = 1;
                    temp[r+2][c+2] = 1;
                }
            }
        }
        int res = 0;
        //int[][] visited = new int[temp.length][temp.length];
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp.length; j++){
                if(temp[i][j] == 0){
                    res++;
                    temp[i][j] = 2;
                    dfsUtils(temp, i, j);
                }
            }
        }
        return res;
    }
}