// Last updated: 6/25/2026, 8:39:39 AM
class Solution {
    public void getCombinations(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k){
        if(k == 0){
            combs.add(new ArrayList<>(comb));
            return;
        } else {
            for(int i = start; i <= n; i++){
                comb.add(i);
                getCombinations(combs, comb, i+1, n, k-1);
                comb.remove(comb.size() - 1);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        this.getCombinations(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
}