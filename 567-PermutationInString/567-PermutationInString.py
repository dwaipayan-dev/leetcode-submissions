# Last updated: 6/25/2026, 8:37:09 AM
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        alphabetFreq = [0 for i in range(26)]
        count = 0
        for i in s1:
            if(alphabetFreq[ord(i) - ord('a')] == 0):
                count += 1
            alphabetFreq[ord(i) - ord('a')] += 1
            
        s1Len = len(s1)
        s2Len = len(s2)
        for i in range(0, s2Len):
            #character enters sliding window
            alphabetFreq[ord(s2[i]) - ord('a')] -= 1
            if(alphabetFreq[ord(s2[i]) - ord('a')] == 0):
                count -= 1
            if(i-s1Len >= 0):
                #character goes out of sliding window
                alphabetFreq[ord(s2[i-s1Len]) - ord('a')] += 1
                if(alphabetFreq[ord(s2[i-s1Len]) - ord('a')] == 1):
                    count += 1
                
            #check if characters in s1 have entered the sliding window
            if(count == 0):
                return True
        return False