// Last updated: 6/25/2026, 8:36:23 AM
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> tripList = new ArrayList<>();
        for(int[] trip: trips){
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];
            tripList.add(new int[]{from, passenger});
            tripList.add(new int[]{to, -passenger});
        }
        Collections.sort(tripList, (int[] a, int[] b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int[] trip: tripList){
            if(capacity >= trip[1]){
                capacity -= trip[1];
            } else {
                return false;
            }
        }
        return true;
    }
}