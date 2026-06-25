// Last updated: 6/25/2026, 8:37:34 AM
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] alphabets = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            char k = magazine.charAt(i);
            int index = k - 'a';
            alphabets[index]++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            char k = ransomNote.charAt(i);
            int index = k - 'a';
            if(alphabets[index] > 0){
                alphabets[index]--;
            } else{
                return false;
            }
        }
        return true;
    }
}