// Last updated: 6/25/2026, 8:38:02 AM
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] alphabets = new char[26];
        if(s.length() != t.length()){
            return false;
        } else{
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                int index = c - 'a';
                alphabets[index]++;
            }
            for(int i = 0; i < t.length(); i++){
                char c = t.charAt(i);
                int index = c - 'a';
                if(alphabets[index] == 0){
                    return false;
                } else {
                    alphabets[index]--;
                }
            }
            return true;
        }
    }
}