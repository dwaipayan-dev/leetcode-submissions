// Last updated: 6/25/2026, 8:37:04 AM
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]){
                count += 1;
                if(i == 0){
                    nums[i] = nums[i+1];
                }
                else if(nums[i+1] < nums[i-1]){
                    nums[i+1] = nums[i];
                }
                else{
                    nums[i] = nums[i+1];
                }
            }
        }
        if(count > 1){
            return false;
        }
        return true;
    }
}