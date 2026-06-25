// Last updated: 6/25/2026, 8:37:47 AM
class Solution {
    public int maxProfit(int[] prices) {
        int[][] temp = new int[prices.length+1][2];
        temp[0][0] = 0;
        temp[0][1] = Integer.MIN_VALUE;

        for(int i = 1; i <= prices.length; i++){
            temp[i][0] = Math.max(temp[i-1][0], temp[i-1][1] + prices[i-1]);
            if(i == 1){

                temp[i][1] = Math.max(temp[i-1][1], -prices[i-1]);
            }
            else{
                temp[i][1] = Math.max(temp[i-1][1], temp[i-2][0] - prices[i-1]);
            } 
        }

        // for(int i = 0 ; i < temp.length; i++){
        //     System.out.println(temp[i][0] + "," + temp[i][1]);
        // }
        //System.out.println(Arrays.toString(temp[1]));
        return temp[prices.length][0];
        
    }
}