// Last updated: 6/25/2026, 8:38:05 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            while(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            dq.offer(i);
            if(i >= k - 1) {
                res[count++] = nums[dq.peek()];
            }
        }
        return res;
    }
}