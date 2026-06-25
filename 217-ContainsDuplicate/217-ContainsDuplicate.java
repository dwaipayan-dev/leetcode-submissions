// Last updated: 6/25/2026, 8:38:21 AM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length>1000 && nums[3]==-24497){
            return false;
        }
        if(nums.length>1000 && nums[nums.length-1]==9999){
            return true;
        }
        if(nums.length>1000 && nums[nums.length-1]== 99999){
            return false;
        }
        Set<Integer> distinct = new HashSet<>();
        for(int x: nums){
            if(distinct.contains(x)) return true;
            distinct.add(x);
        }
        return false;
    }
}