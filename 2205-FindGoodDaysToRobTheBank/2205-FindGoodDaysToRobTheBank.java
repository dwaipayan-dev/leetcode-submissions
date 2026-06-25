// Last updated: 6/25/2026, 8:32:45 AM
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int increasing[] = new int[security.length];
        int decreasing[] = new int[security.length];
        List<Integer> goodDays = new ArrayList<>();
        for(int i = 1; i < security.length - time; i++){
            if(security[i] > security[i-1]){
                decreasing[i] = 0;
            } else{
                decreasing[i] = decreasing[i-1] + 1;
            }
        }
        
        for(int i = security.length - 2; i >= time; i--){
            if(security[i] > security[i+1]){
                increasing[i] = 0;
            } else{
                increasing[i] = increasing[i+1] + 1;
            }
        }
        
        //If consecutive count is greater than time then time days before and after are safe
        for(int i = time; i < security.length - time; i++){
            if(increasing[i] >= time && decreasing[i] >= time){
                goodDays.add(i);
            }
        }
        return goodDays;
    }
}