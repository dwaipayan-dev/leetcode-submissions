# Last updated: 6/25/2026, 8:37:25 AM
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        sorted_g = sorted(g)
        sorted_s = sorted(s)
        count = 0
        index_g = 0
        for j in range(len(s)):
            if index_g == len(g):
                break
            if(sorted_g[index_g] <= sorted_s[j]):
                index_g += 1
                count += 1
        return count 
            
                
            
        