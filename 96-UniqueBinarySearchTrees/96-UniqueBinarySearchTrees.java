// Last updated: 6/25/2026, 8:39:27 AM
class Solution {
    public int dpUtils(int n, int[] temp) {
        if(n == 1 || n == 0) 
            return 1;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(temp[i-1] == 0) {
                temp[i-1] = dpUtils(i-1, temp);
            }
            if(temp[n-i] == 0) {
                temp[n-i] = dpUtils(n-i, temp);
            }
            sum += temp[i-1] * temp[n-i];
        }
        return sum;
    }
    public int numTrees(int n) {
        int[] temp = new int[n+1];
        return dpUtils(n, temp);
    }
}