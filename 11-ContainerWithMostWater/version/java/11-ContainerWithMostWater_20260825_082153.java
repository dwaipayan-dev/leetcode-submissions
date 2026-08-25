// Last updated: 8/25/2026, 8:21:53 AM
/*
 * This is a simple 2 pointer approach. Not to be confused with Trapping rainwater which is a similar question, We take left and right pointers we calculate area taking min(height(left), height(right)) * (right - left), if height of left is less than height of right we increment left else we decrement right
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
*/

1class Solution {
2    public int maxArea(int[] height) {
3        int left = 0;
4        int right = height.length - 1;
5        int maxArea = 0;
6        while(left < right) {
7            int currArea = Math.min(height[left], height[right]) * (right - left);
8            if(height[left] <= height[right]) {
9                left++;
10            } else {
11                right--;
12            }
13            maxArea = Math.max(maxArea, currArea);
14        }
15        return maxArea;
16    }
17}