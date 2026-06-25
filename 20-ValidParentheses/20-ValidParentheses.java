// Last updated: 6/25/2026, 8:40:24 AM
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(st.isEmpty()) {
                if(ch == ')' || ch == '}' || ch == ']') return false;
                st.push(ch);
            } else {
                char top = st.peek();
                if((top == '(' && ch == ')') || 
                (top == '{' && ch == '}') || 
                (top == '[' && ch == ']')) 
                    st.pop();
                else {
                    st.push(ch);
                }
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}