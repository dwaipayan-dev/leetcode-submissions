// Last updated: 6/25/2026, 8:37:13 AM
class Solution {
    public int nextGreaterElement(int n) {
        int pivotIdx = -1;
        char[] charDigits = String.valueOf(n).toCharArray();
        int[] digits = new int[charDigits.length];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = charDigits[i] - '0';
        }
        for(int i = digits.length - 2; i >= 0; i--) {
            if(digits[i] < digits[i+1]) {
                pivotIdx = i;
                break;
            }
        }
        if(pivotIdx < 0) return pivotIdx;
        // System.out.println("pivotIdx: " + pivotIdx + ", pivotNum: " + digits[pivotIdx]);
        int secondGreaterIdx = -1;
        int secondMin = Integer.MAX_VALUE;
        for(int i = pivotIdx+1; i < digits.length; i++){
            if(digits[i] < secondMin && digits[i] > digits[pivotIdx]) {
                secondMin = digits[i];
                secondGreaterIdx = i;
            }
        }
        // System.out.println("seconGreatIdx: " + secondGreaterIdx + ", secondMin: " + digits[secondGreaterIdx]);
        swap(digits, pivotIdx, secondGreaterIdx);
        Arrays.sort(digits, pivotIdx+1, digits.length);
        String res = "";
        for(int d: digits) {
            res += d;
        }
        long resLong = Long.parseLong(res);
        // System.out.println("ans:" + resLong);
        if(resLong > Integer.MAX_VALUE) return -1;
        return (int)resLong;

    }

    public void swap(int[] digits, int start, int end) {
        int temp = digits[start];
        digits[start] = digits[end];
        digits[end] = temp;
    }

    public void reverse(int[] digits, int start, int end){
        while(start < end) {
            swap(digits, start, end);
            start++;
            end--;
        }
    }
}