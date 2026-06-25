// Last updated: 6/25/2026, 8:40:08 AM
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        Arrays.sort(candidates);

        combinationUtils(result, currentSet, 0, target, 0, candidates);
        for(List<Integer> l: result) {
            System.out.println(l);
        }
        return result;
    }

    public void combinationUtils(List<List<Integer>> result, List<Integer> currentSet, int currentSum, int target, int start, int[] candidates) {
        if(currentSum == target) {
            result.add(new ArrayList<Integer>(currentSet));
        } else {
            for(int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i-1]){
                    continue;
                }

                //Early Stopping, not taking the backtracking further when we have impossible result
                if(currentSum + candidates[i] > target) break;
                currentSet.add(candidates[i]);
                combinationUtils(result, currentSet, currentSum + candidates[i], target, i+1, candidates);
                currentSet.remove(currentSet.size() - 1);
            }
        }
    }
}