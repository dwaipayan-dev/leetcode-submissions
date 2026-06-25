// Last updated: 6/25/2026, 8:38:12 AM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int count = 1;
        int currentInt = nums[0];
        int threshold = nums.length/3;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                count++;
            } else {
                if(count > threshold) {
                    res.add(currentInt);
                }
                currentInt = nums[i];
                count = 1;
            }
        }
        if(count > threshold) {
            res.add(currentInt);
        }
        return res;
    }
}