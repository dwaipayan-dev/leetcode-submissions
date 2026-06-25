// Last updated: 6/25/2026, 8:39:30 AM
class Solution {
    //Question is to pick single or double
    public int dpUtils(int[] temp, int i, String s, Map<String, Integer> notAllowed){
        if(i < temp.length && s.charAt(i) == '0') return 0;
        if(i >= temp.length - 1){
            return 1;
        }
        if(temp[i] != -1) return temp[i];
        String k = "" + s.charAt(i) + "" + s.charAt(i+1);
        if(notAllowed.containsKey(k) || Integer.parseInt(k) > 26){
            temp[i] = dpUtils(temp, i+1, s, notAllowed);
        } else {
            temp[i] = dpUtils(temp, i+1, s, notAllowed) + 
            dpUtils(temp, i+2, s, notAllowed);
        }
        return temp[i];
    }
    public int numDecodings(String s) {
      Map<String, Integer> notAllowed = new HashMap<>();
      for(int i = 0; i < 10; i++){
          String entry = "0" + i;
          notAllowed.put(entry, 0);
      }
      int[] temp = new int[s.length()];
      for(int i = 0; i < temp.length; i++){
          temp[i] = -1;
      }
      int res = dpUtils(temp, 0, s, notAllowed);
      return res;
    }
}