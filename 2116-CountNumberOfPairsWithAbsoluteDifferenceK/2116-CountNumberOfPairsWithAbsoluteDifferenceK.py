# Last updated: 6/25/2026, 8:32:48 AM
class Solution:
    def countKDifference(self, nums: List[int], k: int) -> int:
        '''
        count = 0
        n = len(nums)
        for i in range(n-1):
            for j in range(i, n):
                if(abs(nums[i] - nums[j]) == k):
                    count += 1
        return count
        '''
        ans = 0
        freq = {}
        for num in nums:
            if num in freq:
                freq[num] += 1
            else:
                freq[num] = 1
        for num in freq:
            if num + k in freq:
                ans += freq[num] * freq[num + k]
        return ans
        
                    