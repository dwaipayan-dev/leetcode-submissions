# Last updated: 6/25/2026, 8:37:44 AM
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1freq = {}
        result = []
        for i in nums1:
            if(i in nums1freq) == False:
                nums1freq[i] = 1
            else:
                nums1freq[i] += 1
        for i in nums2:
            if(i in nums1freq) == True and nums1freq[i] > 0:
                result.append(i)
                nums1freq[i] -= 1
        
        return result
            
        