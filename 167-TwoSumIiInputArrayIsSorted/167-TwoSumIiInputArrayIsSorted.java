// Last updated: 6/25/2026, 8:38:41 AM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum > target) {
                right--;
            } else if(sum < target) {
                left++;
            } else {
                return new int[]{++left, ++right};
            }
        }
        return new int[]{};
    }
}