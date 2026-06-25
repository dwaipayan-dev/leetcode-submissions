// Last updated: 6/25/2026, 8:36:26 AM
class Solution {
    public void DFSUtils(int[][] grid, int row, int col, int color, int initColor, int[][] visited){
        visited[row][col] = 1;
        int[] direction = {-1, 0, 1, 0, -1};
        for(int i = 0; i < direction.length - 1; i++){
            int r0 = row + direction[i];
            int c0 = col + direction[i + 1];
            if(r0 >= 0 && r0 < grid.length && c0 >= 0 && c0 < grid[0].length && visited[r0][c0] == 0){
                 if(grid[r0][c0] == initColor){
                     DFSUtils(grid, r0, c0, color, initColor, visited);
                     if(r0 == 0 || c0 == 0 || r0 == grid.length-1 || c0 == grid[0].length-1){
                         grid[r0][c0] = color;
                     }
                 } else{
                     grid[row][col] = color;
                 }
            }
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int initColor = grid[row][col];
        int[][] visited = new int[grid.length][grid[0].length];
        DFSUtils(grid, row, col, color, initColor, visited);
        if(row == 0 || col == 0 || row == grid.length-1 || col == grid[0].length-1){
            grid[row][col] = color;
        }
        return grid;
    }
}