// Last updated: 6/25/2026, 8:40:00 AM
class Solution {
    public void getPermutationDFS(List<List<Integer>> perms, List<Integer> perm, int[] nums, int[] visited){
        if(perm.size() == nums.length){
            perms.add(new ArrayList<Integer>(perm));
            return;
        }else{
            for(int i = 0; i < nums.length; i++){
                if(i > 0 && nums[i-1] == nums[i] && visited[i-1] == 0){
                    continue;
                } else{
                    if(visited[i] == 0){
                        visited[i] = 1;
                        perm.add(nums[i]);
                        getPermutationDFS(perms, perm, nums, visited);
                        visited[i] = 0;
                        perm.remove(perm.size() - 1);
                    }
                }
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> perms= new ArrayList<>();
        int[] visited = new int[nums.length];
        getPermutationDFS(perms, new ArrayList<Integer>(), nums, visited);
        return perms;
    }
}