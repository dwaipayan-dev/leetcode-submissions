// Last updated: 6/25/2026, 8:37:40 AM
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        if((n&(n-1)) == 0 && (n-1)%3 == 0){
            return true;
        }
        return false;
    }
}