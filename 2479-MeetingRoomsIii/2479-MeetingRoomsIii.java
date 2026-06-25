// Last updated: 6/25/2026, 8:32:40 AM
class Solution {
    PriorityQueue<Integer> unusedRooms;
    PriorityQueue<long[]> usedRooms;
    public int mostBooked(int n, int[][] meetings) {
        unusedRooms = new PriorityQueue<>();
        usedRooms = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return (int)(a[1] - b[1]);
            return (int)(a[0] - b[0]);
        });
        int[] meetingCount = new int[n];
        for(int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }
        Arrays.sort(meetings, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int[] meeting: meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while(!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int availableRoom = (int)usedRooms.poll()[1];
                unusedRooms.offer(availableRoom);
            }
            if(!unusedRooms.isEmpty()){
                int nextAvailableRoom = unusedRooms.poll();
                usedRooms.offer(new long[]{(long)end, 
                (long)nextAvailableRoom});
                meetingCount[nextAvailableRoom]++;
            } else {
                long[] earliestEndingMeeting = usedRooms.poll();
                int duration = end - start;
                long endNew = earliestEndingMeeting[0] + (long)duration;
                int roomNew = (int)earliestEndingMeeting[1];
                usedRooms.offer(new long[]{endNew, (long)roomNew});
                meetingCount[roomNew]++;
            }
        }

        int maxVal = 0;
        int maxIdx = -1;
        for(int i= 0; i < n; i++) {
            if(meetingCount[i] > maxVal) {
                maxVal = meetingCount[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}