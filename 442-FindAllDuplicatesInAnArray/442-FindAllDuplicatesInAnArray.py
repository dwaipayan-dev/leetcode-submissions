# Last updated: 6/25/2026, 8:37:26 AM
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        numSet = set();
        outputArray = []
        for element in nums:
            if element in numSet:
                outputArray.append(element)
            else:
                numSet.add(element)
        return outputArray
        
        