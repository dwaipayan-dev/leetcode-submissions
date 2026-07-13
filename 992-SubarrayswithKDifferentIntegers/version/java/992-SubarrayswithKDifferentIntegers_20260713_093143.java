// Last updated: 7/13/2026, 9:31:43 AM
// This is a mathematical exclusion with sliding window. Using sliding window we can tell all subarrays where atmost K distinct. And by elimination method to get exact K we do funcAtmost(K) - funcAtmost(K - 1). Similar question is find count of pairs with sum in range (m, n)
1class Solution {
2    // Sliding window to find atmost K distinct 
3    public int subArraysWithAtmostKDistict(int[] nums, int k) {
4        if(k == 0) return 0;
5        Map<Integer, Integer> map = new HashMap<>();
6        int left = 0;
7        int count = 0;
8        for(int right = 0; right < nums.length; right++) {
9            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
10            while(map.size() > k) {
11                map.put(nums[left], map.get(nums[left]) - 1);
12                if(map.get(nums[left]) == 0) {
13                    map.remove(nums[left]);
14                }
15                left++;
16            }
17            // total length of window is added to count as each subarray is valid
18            count += right - left + 1;
19        }
20        return count;
21    }
22
23    public int subarraysWithKDistinct(int[] nums, int k) {
24        // Can be subarrays with atmost k distinct elements = subarrays with K distinct - subarrays with K - 1 distinct
25        return (subArraysWithAtmostKDistict(nums, k) - subArraysWithAtmostKDistict(nums, k - 1));
26    }
27}