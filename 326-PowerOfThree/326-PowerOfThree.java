// Last updated: 6/25/2026, 8:37:42 AM
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        if(1162261467%n == 0) return true;
        return false;
    }
}