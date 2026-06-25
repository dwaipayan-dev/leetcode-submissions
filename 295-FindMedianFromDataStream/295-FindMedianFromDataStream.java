// Last updated: 6/25/2026, 8:37:54 AM
class MedianFinder {
    //For greater half of sorted
    PriorityQueue<Integer> maxHeap;
    //For lesser half of sorted
    PriorityQueue<Integer> minHeap;
    boolean even = true; // 0th step is even
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(even){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return((double)(minHeap.peek() + maxHeap.peek())/2);
        } else{
            return((double)minHeap.peek());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */