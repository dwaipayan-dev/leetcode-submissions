// Last updated: 6/25/2026, 8:40:06 AM
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 1;
        int right = n-2;
        int maxLeft = height[0];
        int maxRight = height[n-1];
        int waterTrapped = 0;
        //To make sure to traverse all walls
        while(left <= right){
            if(maxLeft < maxRight){
                if(height[left] > maxLeft){
                    maxLeft = height[left];
                    //System.out.println(waterTrapped);
                } else {
                    waterTrapped += maxLeft - height[left];
                    //System.out.println(waterTrapped);
                }
                left++;
            } else {
                if(height[right] > maxRight){
                    maxRight = height[right];
                } else {
                    waterTrapped += maxRight - height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }
}