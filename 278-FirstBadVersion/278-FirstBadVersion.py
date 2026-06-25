# Last updated: 6/25/2026, 8:37:59 AM
# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        low = 1
        high = n
        while(low <= high):
            mid = low + (high - low)//2
            if(isBadVersion(mid) == True and isBadVersion(mid - 1) == False):
                return mid
            elif(isBadVersion(mid) == True):
                high = mid - 1
            elif(isBadVersion(mid) == False):
                low = mid + 1
        