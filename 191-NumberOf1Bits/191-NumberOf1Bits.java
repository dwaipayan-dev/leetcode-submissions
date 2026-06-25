// Last updated: 6/25/2026, 8:38:32 AM
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i <= 31; i++){
            if((mask&n) != 0){
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}