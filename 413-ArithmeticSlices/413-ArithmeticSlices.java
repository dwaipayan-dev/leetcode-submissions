// Last updated: 6/25/2026, 8:37:27 AM
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int slices = 0;
        int p = 0;
        for(int i = 2; i < nums.length; i++){
            slices += (nums[i] - nums[i-1] == nums[i-1] - nums[i-2])? ++p: (p = 0);
        }
        return slices;
    }
}