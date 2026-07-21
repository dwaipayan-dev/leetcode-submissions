// Last updated: 7/21/2026, 7:42:51 AM
// This is classic use of stack  time complexity is O(n) as each element is pushed and popped at max from stack
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        Stack<Integer> stack = new Stack<>();
4        Map<Integer, Integer> res = new HashMap<>();
5        for(int i = 0; i < nums2.length; i++) {
6            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
7                int t = stack.pop();
8                res.put(nums2[t], nums2[i]);
9            }
10            stack.push(i);
11        }
12        int[] result = new int[nums1.length];
13        int index = 0;
14        for(int i: nums1) {
15            result[index++] = res.getOrDefault(i, -1);
16        }
17        return result;
18    }
19}