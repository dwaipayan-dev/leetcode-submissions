# Last updated: 6/25/2026, 8:32:50 AM
import sys
class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        sortedNums = sorted(nums, reverse = True)
        n = len(nums)
        min_diff = sys.maxsize
        for i in range(n - k + 1):
            if(min_diff > (sortedNums[i] - sortedNums[i+k -1])):
                min_diff = (sortedNums[i] - sortedNums[i+k -1])
        return min_diff
            
        