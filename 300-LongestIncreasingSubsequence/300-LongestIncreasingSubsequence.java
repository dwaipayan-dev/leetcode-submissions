// Last updated: 6/25/2026, 8:37:53 AM
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > lis[count]) {
                lis[++count] = nums[i];
            } else {
                int j = count;
                while(j >= 0 && nums[i] <= lis[j]) {
                    j--;
                }
                lis[j+1] = nums[i];
            }
        }
        return count + 1;
    }
}