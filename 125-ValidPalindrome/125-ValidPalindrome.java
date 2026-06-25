// Last updated: 6/25/2026, 8:39:00 AM
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        if(j < 0) return false;
        if(j == 0){
            return true;
        }
        while(i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(!Character.isDigit(a) && !Character.isLetter(a)) {
                i++;
                continue;
            }
            if(!Character.isDigit(b) && !Character.isLetter(b)) {
                j--;
                continue;
            }
            String t1 = "" + a;
            String t2 = "" + b;
            if(t1.equalsIgnoreCase(t2)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}