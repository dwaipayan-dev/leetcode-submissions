// Last updated: 8/24/2026, 8:04:22 AM
// Not solved in most efficient way and took a lot of space as reconstructed the string
1class Solution {
2    public String reverseWords(String s) {
3        int n = s.length();
4        String s1 = "";
5        int right = 0;
6        for(int left = 0; left < n; left++) {
7            while(left < n && s.charAt(left) == ' ') {
8                left++;
9            }
10            right = left;
11            while(right < n && s.charAt(right) != ' ') {
12                right++;
13            }
14            String word = s.substring(left, right);
15            left = right;
16            if(s1.length() == 0) {
17                s1 = word + s1;
18            } else {
19                s1 = word + " " + s1;
20            }
21        }
22        return s1.trim();
23
24    }
25}