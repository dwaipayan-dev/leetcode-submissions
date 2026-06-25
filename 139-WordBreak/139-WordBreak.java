// Last updated: 6/25/2026, 8:38:55 AM
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] temp = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(String word: wordDict) {
                // Check if word length exceeds i
                if(i < word.length() - 1) {
                    continue;
                }
                // Check if word length is equal to i or prev segment (i - word.length) is 1 
                if(i == word.length() - 1 || temp[i - word.length()] == 1) {
                    // Check if word is eual to current segment
                    if(s.substring(i - word.length() + 1, i+1).equals(word)) {
                        temp[i] = 1;
                        break;
                    } 
                }
            }
        }
        return temp[s.length() - 1]  == 1? true: false;
    }
}