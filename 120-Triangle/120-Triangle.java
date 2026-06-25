// Last updated: 6/25/2026, 8:39:06 AM
class Solution {
    public int dpUtils(List<List<Integer>> triangle, int level, int index, int[][] temp){
        if(level == triangle.size()){
            return 0;
        }
        if(temp[level][index] != -1){
            return temp[level][index];
        } 
        temp[level][index] = triangle.get(level).get(index) + 
            Math.min(dpUtils(triangle, level + 1, index, temp), 
                dpUtils(triangle, level + 1, index + 1, temp));
        return temp[level][index];
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] temp = new int[triangle.size()][triangle.size()];
        for (int[] row: temp)
            Arrays.fill(row, -1);
        return dpUtils(triangle, 0, 0, temp);
    }
}