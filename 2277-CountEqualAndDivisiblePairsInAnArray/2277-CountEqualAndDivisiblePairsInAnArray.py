# Last updated: 6/25/2026, 8:32:42 AM
class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        indexList = []
        freq = {}
        for index in range(len(nums)):
            element = nums[index]
            if element in freq:
                freq[element].append(index)
            else:
                freq[element] = [index]
        ans = 0
        for key, value in freq.items():
            while(len(value) > 1):
                a = value.pop(0)
                for b in value:
                    if((a*b)%k == 0):
                        ans += 1
        return ans
                