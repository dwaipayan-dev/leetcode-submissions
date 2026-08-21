// Last updated: 8/21/2026, 7:04:56 AM
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int t = stack.pop();
                res.put(nums2[t], nums2[i]);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for(int i: nums1) {
            result[index++] = res.getOrDefault(i, -1);
        }
        return result;
    }
}