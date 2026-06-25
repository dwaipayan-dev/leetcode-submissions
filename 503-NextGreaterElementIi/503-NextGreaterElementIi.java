// Last updated: 6/25/2026, 8:37:21 AM
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] numsCirc = new int[nums.length * 2];
        int[] nextGreat = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++){
            numsCirc[i] = nums[i];
            numsCirc[nums.length + i] = nums[i];
        }
        //System.out.println(Arrays.toString(numsCirc));
        Stack<Integer> s = new Stack<>();
        int n = nums.length * 2;
        for(int i = n-1; i >= 0; i--){
            if(s.isEmpty() || numsCirc[s.peek()] > numsCirc[i])
                s.push(i);
            else{
                int idx = s.pop();
                //System.out.println(idx);
                if(s.isEmpty()){
                    //System.out.println(idx);
                    nextGreat[idx] = -1;
                } else {
                    nextGreat[idx] = numsCirc[s.peek()];
                }
                i++;
            }
            //System.out.println(s);
        }
        while(!s.isEmpty()){
            int idx = s.pop();
            if(s.isEmpty()){
                    //System.out.println(idx);
                nextGreat[idx] = -1;
            } else {
                nextGreat[idx] = numsCirc[s.peek()];
            }
        }
        int[] res = new int[n/2];
        for(int i = 0; i < n/2; i++){
            res[i] = nextGreat[i];
        }
        return res;
    }
}