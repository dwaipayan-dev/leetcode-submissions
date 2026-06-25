# Last updated: 6/25/2026, 8:38:26 AM
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        freq = {}
        for i in nums:
            if(i in freq.keys()) == False:
                freq[i] = 1
            else:
                return True
        return False
        