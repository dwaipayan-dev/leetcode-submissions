// Last updated: 6/25/2026, 8:39:41 AM
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch: t.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        int limit = t.length();
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = Integer.MAX_VALUE;
        while(right < s.length()) {
            char ch0 = s.charAt(right);
            int freq = charMap.getOrDefault(ch0, 0);
            if(freq > 0) limit--;
            charMap.put(ch0, freq - 1);
            while(limit == 0) {
                char ch1 = s.charAt(left);
                freq = charMap.get(ch1);
                if(freq == 0) limit++;
                charMap.put(ch1, freq + 1);
                if(right - left < minRight - minLeft) {
                    minRight = right;
                    minLeft = left;
                }
                left++;
            }
            right++;
        }
        return minRight >= s.length()? "": s.substring(minLeft, minRight + 1);
    }
}