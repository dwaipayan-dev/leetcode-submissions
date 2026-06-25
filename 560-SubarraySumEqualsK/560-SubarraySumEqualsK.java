// Last updated: 6/25/2026, 8:37:12 AM
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        Map<Integer, Integer> freqOfSum = new HashMap<>();
        freqOfSum.put(prefixSum[0], 1);
        int count = 0;
        if(prefixSum[0] == k) count++;
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            if(prefixSum[i] == k) count++;
            count += freqOfSum.getOrDefault(prefixSum[i] - k, 0);
            freqOfSum.put(prefixSum[i], freqOfSum.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }
}