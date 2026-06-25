// Last updated: 6/25/2026, 8:37:22 AM
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(temp[i], Integer.MIN_VALUE);
        }
        return maxDiff(temp, nums, 0, n-1) >= 0;
    }

    public int maxDiff(int[][] temp, int[] nums, int left, int right) {
        if(left > right) {
            return 0;
        } else if(temp[left][right] != Integer.MIN_VALUE) {
            return temp[left][right];
        }
        int p1 = nums[left] - maxDiff(temp, nums, left + 1, right);
        int p2 = nums[right] - maxDiff(temp, nums, left, right - 1);
        temp[left][right] = Math.max(p1, p2);
        return temp[left][right];
    }
}