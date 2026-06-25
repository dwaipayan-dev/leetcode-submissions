// Last updated: 6/25/2026, 8:38:31 AM
class Solution {
    public int rob(int[] nums) {
        int[] temp = new int[nums.length + 1];
        temp[0] = 0;
        temp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            temp[i] = Math.max(temp[i-1], temp[i-2] + nums[i-1]);
        }
        return temp[nums.length];
    }
}