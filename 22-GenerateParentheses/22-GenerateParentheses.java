// Last updated: 6/25/2026, 8:40:22 AM
class Solution {
    public void addString(int n, int open, int close, String s, List<String> list) {
        if(s.length() == n * 2) {
            list.add(s);
            return;
        }
        if(open < n) {
            addString(n, open + 1, close, s + "(", list);
        }
        if(close < open) {
            addString(n, open, close + 1, s + ")", list);
        }
    }
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int close = 0;
        List<String> list = new ArrayList<>();
        addString(n, open, close, "", list);
        return list;
    }
}