// Last updated: 6/25/2026, 8:38:33 AM
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 31; i++){
            res += (n & 1);
            res <<= 1;
            n >>= 1;
        }
        res += (n&1);
        return res;
        
    }
}