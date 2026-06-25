// Last updated: 6/25/2026, 8:38:44 AM
class Solution {
    public int maxProduct(int[] nums) {
        int left = 0;
        int right = 0;
        int res = nums[0];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            left = (left == 0? 1: left) * nums[i];
            right = (right == 0? 1: right) * nums[n-1-i];
            res = Math.max(Math.max(left, right), res);
        }
        return res;
    }
}