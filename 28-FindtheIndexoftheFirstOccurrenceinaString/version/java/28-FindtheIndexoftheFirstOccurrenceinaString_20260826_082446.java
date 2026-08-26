// Last updated: 8/26/2026, 8:24:46 AM
/*
 * Some bugs. Like iterating till hLen - nLen + 1 (so that if length is equal even then it works
 * 
 * Time complexity: O(hLen * nLen)
 * 
 * Space complexity: 1
*/

1class Solution {
2    public int strStr(String haystack, String needle) {
3        int hLen = haystack.length();
4        int nLen = needle.length();
5        if(hLen < nLen) return -1;
6        for(int i = 0; i < hLen - nLen + 1; i++) {
7            if(haystack.substring(i, i + nLen).equals(needle)) {
8                return i;
9            }
10        } 
11        return -1;
12    }
13}