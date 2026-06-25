// Last updated: 6/25/2026, 8:38:11 AM
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false; 
        if((n&(n-1)) == 0){
            return true;
        } return false;
    }
}