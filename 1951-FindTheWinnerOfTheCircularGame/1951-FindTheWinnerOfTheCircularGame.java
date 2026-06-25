// Last updated: 6/25/2026, 8:32:58 AM
class Solution {
    public int josephus(int n, int k) {
        if(n == 1) return 0;
        return (k + josephus(n-1, k))%n;
    }
    public int findTheWinner(int n, int k) {
        if(k > n) k = k%n;
        return josephus(n, k) + 1;
    }
}