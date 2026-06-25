// Last updated: 6/25/2026, 8:40:16 AM
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        //char[] chArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else { 
                    int currLen = i - stack.peek();
                    maxLength = Math.max(maxLength, currLen);
                }
            }
        }
        return maxLength;
    }
}