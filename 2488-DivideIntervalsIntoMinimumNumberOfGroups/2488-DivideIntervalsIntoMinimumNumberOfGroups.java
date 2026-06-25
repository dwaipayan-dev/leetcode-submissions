// Last updated: 6/25/2026, 8:32:38 AM
class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (int[] a, int[] b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int nGroups = 0;
        for(int[] interval: intervals){
            if(!pq.isEmpty() && pq.peek() < interval[0]){
                pq.poll();
            } else {
                nGroups++;
            }
            pq.offer(interval[1]);
        }
        return nGroups;
    }
}