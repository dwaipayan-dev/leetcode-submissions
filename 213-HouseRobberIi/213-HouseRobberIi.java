// Last updated: 6/25/2026, 8:38:20 AM
class Solution {
    public int maxProfit(int[] nums){
        int[] profit = new int[nums.length];
        if(nums.length > 0)
            profit[0] = nums[0];
        if(nums.length > 1)
            profit[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            profit[i] = Math.max(nums[i] + profit[i - 2], profit[i-1]);
        }
        return profit[nums.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        for(int i = 0; i < nums.length - 1; i++){
            nums1[i] = nums[i];
            nums2[i] = nums[i+1];
        }
        return Math.max(maxProfit(nums1), maxProfit(nums2));
    }
}