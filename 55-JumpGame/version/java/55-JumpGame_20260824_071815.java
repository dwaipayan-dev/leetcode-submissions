// Last updated: 8/24/2026, 7:18:15 AM
/*
 * This is a fast and slow pointer approach common questions around it are remove elements, remove duplicate, move zeroes etc.
 * 
 * Time Complexity: O(n)
 * Space complexity: O(1)
*/

1class Solution {
2    public int removeElement(int[] nums, int val) {
3        int slow = 0;
4        for(int fast = 0; fast < nums.length; fast++) {
5            if(nums[fast] != val) {
6                nums[slow] = nums[fast];
7                slow++;
8            }
9        }
10        return slow;
11    }
12}