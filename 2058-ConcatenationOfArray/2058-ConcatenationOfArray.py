# Last updated: 6/25/2026, 8:32:55 AM
class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        ans = []
        n = len(nums)
        for i in range(2*n):
            ans.append(nums[i%n])
        return ans
        