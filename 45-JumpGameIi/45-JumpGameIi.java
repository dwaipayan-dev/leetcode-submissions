// Last updated: 6/25/2026, 8:40:04 AM
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= nums[i]; j++){
                if(i+j >= n ) continue;
                if(temp[i+j] == 0){
                    temp[i+j] = temp[i] + 1;
                } else {
                    temp[i+j] = Math.min(temp[i+j], temp[i] + 1);
                }
            }
        }
        //System.out.println(Arrays.toString(temp));
        return temp[n-1];
    }
}