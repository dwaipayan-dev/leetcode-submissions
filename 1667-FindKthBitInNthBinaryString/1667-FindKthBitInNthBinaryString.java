// Last updated: 6/25/2026, 8:33:01 AM
class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) {
            return '0'; // always
        }
        int length = (1 << n);
        if(k < length/2) {
            return findKthBit(n-1, k); // Don't make any change in position or bit
        }
        if(k == length/2) {
            return '1'; // always
        }
        return (findKthBit(n-1, length-k) == '0'? '1': '0'); 
        //Reverse new k's position and invert resultant bit
    }
}