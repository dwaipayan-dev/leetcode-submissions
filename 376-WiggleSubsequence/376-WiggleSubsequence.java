// Last updated: 6/25/2026, 8:37:37 AM
class Solution {
    public int wiggleMaxLength(int[] nums) {
        Boolean flag = null;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if(diff > 0) {
                // Pos diff
                if(flag == null || flag == true) {
                    flag = false;
                    count++;
                }
            } else if(diff < 0) {
                // Neg diff
                if(flag == null || flag == false) {
                    flag = true;
                    count++;
                }
            }
        } 
        return count;
    }
}