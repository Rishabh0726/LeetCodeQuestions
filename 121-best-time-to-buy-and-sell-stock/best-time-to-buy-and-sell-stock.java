class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int dayProfit=0;
        int buy=Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(buy>=prices[i]){
                buy=prices[i];
            }
            if(buy<prices[i]){
                dayProfit=prices[i]-buy;
            }
            if(dayProfit>profit){
                profit=dayProfit;
            }
        }
        return profit;
    }
}