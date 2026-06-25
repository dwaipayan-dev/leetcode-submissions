// Last updated: 6/25/2026, 8:36:30 AM
class Solution {
    public int orangesRotting(int[][] grid) {
        int nrow = grid.length;
        int ncol = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int count = 0;
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(grid[i][j] == 1){
                    count++;
                } else{
                    if(grid[i][j] == 2){
                        queue.offer(new int[] {i, j, time});
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentTime = current[2];
            time = currentTime;
            int[] direction = {-1, 0, 1, 0, -1};
            for(int k = 0; k < direction.length - 1; k++){
                int r = current[0] + direction[k];
                int c = current[1] + direction[k+1];
                if(r < 0 || r >= nrow || c < 0 || c >= ncol){
                    continue;
                } else{
                    if(grid[r][c] == 1){
                        count--;
                        grid[r][c] = 2;
                        queue.offer(new int[] {r, c, currentTime + 1});
                    }
                }
            }
        }
        if(count != 0){
            return -1;
        } else{
            return time;
        }
    }
}