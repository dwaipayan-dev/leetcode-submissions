# Last updated: 6/25/2026, 8:40:31 AM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq = {}
        j = 0
        maxLen = 0
        for i in range(0, len(s)):
            if(s[i] in freq) == True:
                j = max(j, freq[s[i]] + 1)
            freq[s[i]] = i
            maxLen = max(maxLen, i - j + 1)
        return maxLen
        