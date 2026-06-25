// Last updated: 6/25/2026, 8:36:33 AM
class Solution {
    public int dpUtils(int[] temp, int n) {
        if(n == 0 || n == 1) {
            return n;
        } else {
            if(temp[n] != 0) {
                return temp[n];
            } else {
                temp[n] = dpUtils(temp, n-1) + dpUtils(temp, n - 2);
                return temp[n];
            }
        }
    } 
    public int fib(int n) {
        int[] temp = new int[n+1];
        return dpUtils(temp, n);
    }
}