// Last updated: 8/25/2026, 8:37:52 AM
// For singe digits only 1 and 7 are happy numbers
1class Solution {
2    public boolean isHappy(int n) {
3        if(n == 1 || n == 7) return true;
4        if(n < 10) return false;
5        int sum = 0;
6        while(n != 0) {
7            int t = n%10;
8            sum += t*t;
9            n = n/10;
10        }
11        return isHappy(sum);
12    }
13}