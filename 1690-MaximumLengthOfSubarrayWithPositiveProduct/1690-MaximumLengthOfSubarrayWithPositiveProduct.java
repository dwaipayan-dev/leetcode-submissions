// Last updated: 6/25/2026, 8:33:00 AM
class Solution {
    public int getMaxLen(int[] nums) {
        int positiveLen = 0, negativeLen = 0;
        //Positive len is length of subarray where product of all elements is +ve,
        //Negative len is length of subarray where product of all elements is -ve,
        //On encountering a zero both positive and negative Len would reset to 0;
        int maxLen = 0;
        for(int x: nums){
            if(x == 0){
                positiveLen = 0;
                negativeLen = 0;
            }
            else if(x > 0){
                positiveLen = positiveLen + 1;
                negativeLen = negativeLen == 0? 0: negativeLen+1;
            }
            else{
                //If -ve number is encountered then positive len would 
                //become negative Len + 1 if negativeLen > 0 else 0
                int temp = positiveLen;
                positiveLen = negativeLen == 0? 0: negativeLen + 1;
                negativeLen = temp + 1;
            }
            maxLen = Math.max(maxLen, positiveLen);
        }
        return maxLen;
    }
}