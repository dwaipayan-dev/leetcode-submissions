// Last updated: 6/25/2026, 8:40:17 AM
class Solution {
    public int findNextMax(int[] nums, int index, int target){
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int k = index + 1; k < nums.length; k++){
            if(nums[k] <= minVal && nums[k] > target){
                minVal = nums[k];
                minIndex = k;
            }
        }
        return minIndex;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return;
        }
        for(int i = n - 2; i >= 0; i--){
            //System.out.println(i);
            int swapIndex = findNextMax(nums, i, nums[i]);
            if(swapIndex == -1) continue;
            else{
                int t = nums[swapIndex];
                nums[swapIndex] = nums[i];
                nums[i] = t;
                int start = i+1;
                int end = n-1;
                //System.out.println(nums[i] + " " + start + " " + end);
                while(start < end){
                    //System.out.println(nums[start] + " "+ nums[end]);
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
                return;
            }
        }
        Arrays.sort(nums);
    }
}