# Last updated: 6/25/2026, 8:32:51 AM
class Solution:
    def findGCD(self, nums: List[int]) -> int:
        min_num = min(nums)
        max_num = max(nums)
        return self.calcGCD(max_num, min_num)
        
    def calcGCD(self, m, n):
        if(n == 0 and m == 0):
            return 1
        elif(n == 0):
            return m
        else:
            while(n > 0):
                temp = n
                n = m%n
                m = temp
            return m
                
        