# Last updated: 6/25/2026, 8:32:54 AM
class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        sToCompare = ""
        for word in words:
            sToCompare += word
            if(s == sToCompare):
                return True
        return False
        