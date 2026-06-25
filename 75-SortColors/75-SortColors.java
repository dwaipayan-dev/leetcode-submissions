// Last updated: 6/25/2026, 8:39:42 AM
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i <= right; i++) {
            if(nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
            if(nums[i] == 2) {
                swap(nums, right, i);
                right--;
                i--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}