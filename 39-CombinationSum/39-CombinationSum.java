// Last updated: 6/25/2026, 8:40:09 AM
class Solution {
    
    public void backtrackUtils(List<List<Integer>>res, List<Integer> current, int[] candidates, int target, int sum, int index) {
                if(sum == target) {
                    res.add(new ArrayList<>(current));
                }
                else if(sum < target) {
                    for(int i = index; i < candidates.length; i++){
                    current.add(candidates[i]);
                        backtrackUtils(res, current, candidates, target, sum + candidates[i], i);
                    current.remove(current.size() - 1);
                }

            }
                
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackUtils(res, new ArrayList<Integer>(), candidates, target, 0, 0);
        return res;
    }
}