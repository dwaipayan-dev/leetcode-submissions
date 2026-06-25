// Last updated: 6/25/2026, 8:36:16 AM
class Node {
    int id;
    int start;
    int end;
    String from;
    String to;
    public Node(int id, int start, String from){
        this.id = id;
        this.start = start;
        this.from = from;
    }
}
class UndergroundSystem {
    Map<String, Double> avgTimeAToB;
    Map<Integer, Node> userMap;
    Map<String, Integer> countMap;
    public UndergroundSystem() {
        avgTimeAToB = new HashMap<>();
        userMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        Node newUser = new Node(id, t, stationName);
        userMap.put(id, newUser);
    }
    
    public double calcAvg(int n, double prevAvg, double k){
        return (n*prevAvg + k)/(n+1);
    }
    public void checkOut(int id, String stationName, int t) {
        Node existingUser = userMap.get(id);
        existingUser.to = stationName;
        existingUser.end = t;
        double time = existingUser.end - existingUser.start;
        String journey = existingUser.from +"->"+existingUser.to;
        int prevJourneys = countMap.getOrDefault(journey, 0);
        double avgTime = prevJourneys == 0? time: 
        calcAvg(prevJourneys, avgTimeAToB.get(journey), time);
        avgTimeAToB.put(journey, avgTime);
        countMap.put(journey, ++prevJourneys);
        userMap.remove(existingUser);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String journey = startStation + "->" + endStation;
        return avgTimeAToB.get(journey);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */