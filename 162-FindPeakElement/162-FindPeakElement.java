// Last updated: 6/25/2026, 8:38:40 AM
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0; 
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length -1] > nums[nums.length - 2]) return nums.length -1;
        int start = 1;
        int end = nums.length -2;
        while(start <= end) {
            int mid = start + ((end - start)/2);
            System.out.println(mid);
            if(nums[mid] <= nums[mid-1]) {
                end = mid - 1;
            } else if(nums[mid] <= nums[mid+1]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}