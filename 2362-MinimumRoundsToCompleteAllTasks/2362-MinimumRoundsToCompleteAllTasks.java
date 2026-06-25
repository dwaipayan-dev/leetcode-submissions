// Last updated: 6/25/2026, 8:32:41 AM
class Solution {
    public int doTaskFibb(int n){
        if(n == 1){
            return -1;
        }
        int rounds = n/3;
        if(n % 3 != 0){
            rounds++;
        }
        return rounds;
    }
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int t = 0; t < tasks.length; t++){
            if(freq.containsKey(tasks[t]) == false){
                freq.put(tasks[t], 1);
            } else{
                freq.put(tasks[t], freq.get(tasks[t])+1);
            }
        }
        int sum = 0;
        for(int key: freq.keySet()){
            int ways = doTaskFibb(freq.get(key));
            if(ways == -1){
                return -1;
            } else{
                sum += ways;
            }
        }
        return sum;
    } 
}