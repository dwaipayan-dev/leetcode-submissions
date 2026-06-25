// Last updated: 6/25/2026, 8:40:27 AM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int i = 0, j = 0;
        for(int index = 0; index < m + n; index++) {
            int temp;
            if( i < m && j < n) {
                if(nums1[i] <= nums2[j]) {
                    temp = nums1[i];
                    i++;
                } else {
                    temp = nums2[j];
                    j++;
                }
            }
            else if(i < m) {
                temp = nums1[i];
                i++;
            }
            else{
                temp = nums2[j];
                j++;
            }
            if(index%2 == 0) {
                maxHeap.offer(temp);
                int balanceValue = maxHeap.poll();
                minHeap.offer(balanceValue);
            } else {
                minHeap.offer(temp);
                int balanceValue = minHeap.poll();
                maxHeap.offer(balanceValue);
            }
        }
        if((m+n)%2 == 0) {
            return (double)(maxHeap.poll() + minHeap.poll())/2;
        }
        else {
            return (double)minHeap.poll();
        }
    }
}