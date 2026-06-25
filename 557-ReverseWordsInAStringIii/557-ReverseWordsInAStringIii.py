# Last updated: 6/25/2026, 8:37:19 AM
class Solution:
    def reverse(self, charArr: List[str], start: int , end: int):
        startPtr = start
        endPtr = end
        while(startPtr < endPtr):
            t = charArr[startPtr]
            charArr[startPtr] = charArr[endPtr]
            charArr[endPtr] = t
            startPtr += 1
            endPtr -= 1
            
    def reverseWords(self, s: str) -> str:
        charArr = [letter for letter in s]
        p = 0
        for i in range(len(charArr)):
            if(charArr[i] == ' '):
                self.reverse(charArr, p, i - 1)
                p = i+1
        self.reverse(charArr, p, len(charArr)-1)
        return ("".join(charArr))
            
            
        