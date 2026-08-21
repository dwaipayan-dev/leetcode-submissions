// Last updated: 8/21/2026, 7:02:29 AM
/*
 * The question is Wiggle Subsequence so we are allowed to skip elements hence solution will be a greedy one where we use a flag to indicate pos and neg diff.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
*/

1class Solution {
2    public int wiggleMaxLength(int[] nums) {
3        if(nums.length == 0) return 0;
4        int count = 1;
5        Boolean flag = null;
6        int maxLen = 0;
7        for(int i = 1; i < nums.length; i++) {
8            int diff = nums[i] - nums[i-1];
9            if(diff > 0) {
10                if(flag == null || flag == false) {
11                    flag = true;
12                    count++;
13                }
14            }
15            if(diff < 0) {
16                if(flag == null || flag == true) {
17                    flag = false;
18                    count++;
19                } 
20            } 
21        }
22        return count;
23    }
24}