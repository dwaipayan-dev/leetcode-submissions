// Last updated: 6/25/2026, 8:38:25 AM
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        //Use boolean to save space boolean = 1 bytes int = 4 bytes
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        //in a range prime numbers only exist within square root of n
        for(int i = 2; i * i < n; i++) {
            if(isPrime[i]) {
                // j's series = i * 2, i * 3, i* 4
                for(int j = 2 * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            count += isPrime[i] ? 1: 0;
        }
        return count;
    }
}