// Last updated: 6/25/2026, 8:37:36 AM
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] n = new int[target+1];
        n[0] = 1;
        for(int i = 0; i < n.length; i++) {
            for(int j: nums){
                if(i-j >= 0){
                    n[i] += n[i-j];
                }
            }
            System.out.println(Arrays.toString(n));
        }
        return n[target];
    }
}