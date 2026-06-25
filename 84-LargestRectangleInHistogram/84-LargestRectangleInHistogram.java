// Last updated: 6/25/2026, 8:39:34 AM
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int i;
        for(i = 0; i < heights.length; i++){
            if(s.isEmpty() || heights[s.peek()] <= heights[i]) {
                s.push(i);
            } else {
                int top = s.pop();
                int curr = heights[top] * (s.isEmpty()?i: i-s.peek()-1);
                maxArea = Math.max(maxArea, curr);
                i--;
            }
        }
        while(!s.isEmpty()){
            int top = s.pop();
            int curr = heights[top] * (s.isEmpty()?i: i-s.peek()-1);
            maxArea = Math.max(maxArea, curr);
        }
        return maxArea;
    }
}