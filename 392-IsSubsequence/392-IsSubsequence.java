// Last updated: 6/25/2026, 8:37:32 AM
class Solution {
    public boolean isSubsequence(String s, String t) {
        int indexs = 0;
        int indext = 0;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        while(indext < charT.length && indexs < charS.length){
            if(charS[indexs] == charT[indext]){
                indexs++;
            }
            indext++;
        }
        if(indexs == s.length()){
            return true;
        }
        return false;
    }
}