// Last updated: 6/25/2026, 8:38:39 AM
class Solution {
    public int majorityElement(int[] nums) {
        int current = nums[0];
        int freq = 1;
        for(int i = 1; i < nums.length; i++) {
            if(current != nums[i]) {
                if(freq == 0) {
                    current = nums[i];
                    freq = 1;
                } else {
                    freq--;
                }
            } else {
                freq++;
            }
        }

        return current;
    }
}