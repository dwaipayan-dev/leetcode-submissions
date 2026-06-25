// Last updated: 6/25/2026, 8:37:29 AM
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] temp = new boolean[n][n+1];
        temp[0][1] = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = stones[i] - stones[j];
                if(diff < 0 || diff >= n || !temp[j][diff]) continue;
                temp[i][diff] = true;
                if(diff - 1 >= 0) temp[i][diff - 1] = true;
                if(diff + 1 <= n) temp[i][diff + 1] = true;
                if(i == n-1) return true;
            }
        }
        return false;
    }
}