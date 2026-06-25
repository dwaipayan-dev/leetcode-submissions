// Last updated: 6/25/2026, 8:37:33 AM
class Solution {
    public int lastRemaining(int n) {
        int step = 1;
        int head = 1;
        int size = n;
        boolean left = true;
        while(n > 1) {
            if(left == true || n%2 == 1) {
                head = head + step;
            }
            step = step * 2;
            left = !left;
            n /= 2;
        }
        return head;
    }
}