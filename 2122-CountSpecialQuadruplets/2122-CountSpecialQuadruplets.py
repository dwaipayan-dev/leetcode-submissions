# Last updated: 6/25/2026, 8:32:49 AM
class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        
        a_plus_b = {}
        res = 0
        n = len(nums)
        for c in range(0, n-1):
            for d in range(c+1, n):
                if (nums[d] - nums[c]) in a_plus_b:
                    #a_plus_b[nums[d] - nums[c]] += 1
                    pass
                else:
                    a_plus_b[nums[d] - nums[c]] = 0
                
                res += a_plus_b[nums[d] - nums[c]] 
            b = c
            for a in range(b):
                if (nums[a] + nums[b]) in a_plus_b:
                    a_plus_b[nums[a] + nums[b]] += 1
                else:
                    a_plus_b[nums[a] + nums[b]] = 1
        return res
        '''
        res=0
        a_plus_b = collections.defaultdict(int)
        for c in range(len(nums)-1):
            for d in range(c+1,len(nums)):
                print(a_plus_b[nums[d]-nums[c]])
                res+=a_plus_b[nums[d]-nums[c]]
            b = c
            for a in range(b):
                a_plus_b[nums[a]+nums[b]]+=1
        return res
        '''