// Last updated: 6/25/2026, 8:37:41 AM
class Solution {
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        while(head < tail){
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            head += 1;
            tail -= 1;
        }
    }
}