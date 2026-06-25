// Last updated: 6/25/2026, 8:37:52 AM
class Solution {
    StringBuilder curr;
    Set<String> res = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftCount = 0;
        int rightCount = 0;
        for(char t: s.toCharArray()) {
          if(t == '('){
            leftCount++;
          } 
          else if(t == ')') {
            if(leftCount > 0) {
              leftCount--;
            } else {
              rightCount++;
            }
          }
        }
        this.curr = new StringBuilder();
        backtrackUtils(0, 0, leftCount, rightCount, 0, s);
        return new ArrayList<String>(this.res);
    }

    public void backtrackUtils(int left, int right, int leftCount, int rightCount, int index, String s) {
      if(index == s.length()) {
        if(leftCount == 0 && rightCount == 0) {
          this.res.add(this.curr.toString());
        }
      } else {
          char t = s.charAt(index);
          int length = this.curr.length();
          //discard case
          if((t == '(' && leftCount > 0) || (t == ')' && rightCount > 0)) {
            backtrackUtils(
            left, 
            right, 
            leftCount - (t == '('? 1: 0),
            rightCount - (t == ')'? 1: 0),
            index+1,
            s);
          }
          this.curr.append(t);
          
          //accept case
          if(t != '(' && t != ')'){
            backtrackUtils(left, right, leftCount, rightCount, index + 1, s);
          } else {
              if(t == '(') {
                backtrackUtils(left+1, right, leftCount, rightCount, index + 1, s);
              } else {
                if(left > right) {
                  backtrackUtils(left, right+1, leftCount, rightCount, index + 1, s);
                }
              }
              
          }
          this.curr.deleteCharAt(length);
          
      }
    }
}
