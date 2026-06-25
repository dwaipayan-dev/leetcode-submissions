// Last updated: 6/25/2026, 8:36:58 AM
class MyCalendarTwo {
    List<int[]> booking;
    List<int[]> overlap;
    public MyCalendarTwo() {
       booking = new ArrayList<>();
       overlap = new ArrayList<>(); 
    }
    
    public boolean book(int startTime, int endTime) {
        // Check if triple booking 
        for(int[] o: overlap) {
            if(Math.max(o[0], startTime) < Math.min(o[1], endTime)) {
                return false;
            }
        }
        // Check if double booking
        for(int []b: booking) {
            if(Math.max(b[0], startTime) < Math.min(b[1], endTime)) {
                int overlapStart = Math.max(b[0], startTime);
                int overlapEnd = Math.min(b[1], endTime);
                overlap.add(new int[]{overlapStart, overlapEnd});
            }
        }
        booking.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */