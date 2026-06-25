// Last updated: 6/25/2026, 8:37:00 AM
class MyCalendar {
    TreeSet<int[]> ts;
    public MyCalendar() {
        ts = new TreeSet<>((a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
    }
    
    public boolean book(int startTime, int endTime) {
        int[] booking = new int[]{startTime, endTime};
        if(ts.floor(booking) != null) {
            int[] leftBooking = ts.floor(booking);
            if(startTime < leftBooking[1]) {
                return false;
            }
        }
        if(ts.ceiling(booking) != null) {
            int[] rightBooking = ts.ceiling(booking);
            if(endTime > rightBooking[0]) {
                return false;
            }
        }
        ts.add(booking);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */