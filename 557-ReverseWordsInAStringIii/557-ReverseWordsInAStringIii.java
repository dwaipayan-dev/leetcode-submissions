// Last updated: 6/25/2026, 8:37:14 AM
class Solution {
    public String reverseWord(String word){
        char[] wordArr = word.toCharArray();
        int start = 0;
        int end = wordArr.length - 1;
        while(start < end){
            char temp = wordArr[start];
            wordArr[start] = wordArr[end];
            wordArr[end] = temp;
            start += 1;
            end -= 1;
        }
        String result = "";
        for(char t: wordArr){
            result += t;
        }
        return result;
    }
    public String reverseWords(String s) {
        String[] wordsArr = s.split(" ");
        int count = 0;
        for(String word: wordsArr){
            wordsArr[count] = reverseWord(word);
            count += 1;
        }
        return String.join(" ", wordsArr);
    }
}