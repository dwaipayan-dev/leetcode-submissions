// Last updated: 6/25/2026, 8:36:46 AM
class Solution {
    public void getLetterCasePermutations(List<String> perms, char[] perm, int index){
        if(index == perm.length){
            perms.add(new String(perm));
            //System.out.println();
            return;
        } else {
            if(Character.isDigit(perm[index])){
                getLetterCasePermutations(perms, perm, index + 1);
                return;
            } else{
                perm[index] = Character.toLowerCase(perm[index]);
                //System.out.println(perm);
                getLetterCasePermutations(perms, perm, index + 1);
                perm[index] = Character.toUpperCase(perm[index]);
                //System.out.println(perm);
                getLetterCasePermutations(perms, perm, index + 1);
            }
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> perms = new ArrayList<>();
        char[] chars = s.toCharArray();
        getLetterCasePermutations(perms, chars, 0);
        return perms;
        
    }
}