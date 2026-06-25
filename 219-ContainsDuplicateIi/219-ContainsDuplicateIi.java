// Last updated: 6/25/2026, 8:38:17 AM
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(freq.containsKey(nums[i]) == false){
                freq.put(nums[i], i);
            } else {
                if(i - freq.get(nums[i]) <= k) {
                    return true;
                }
                freq.put(nums[i], i);
            }
        }

        return false;
    }
}