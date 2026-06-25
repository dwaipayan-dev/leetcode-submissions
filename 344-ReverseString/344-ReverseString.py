# Last updated: 6/25/2026, 8:37:46 AM
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        strLength = len(s)
        startPtr = 0
        endPtr = strLength - 1
        while(startPtr < endPtr):
            t = s[startPtr]
            s[startPtr] = s[endPtr]
            s[endPtr] = t
            startPtr += 1
            endPtr -= 1