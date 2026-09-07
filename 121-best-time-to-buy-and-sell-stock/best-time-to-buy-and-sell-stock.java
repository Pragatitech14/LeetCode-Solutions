class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy_prices =prices[0];
        int maxprofit=0;
        for(int i=0;i<n;i++)
        {
          if(buy_prices>prices[i])
          {
            buy_prices=prices[i];
          }
          else
          {
         maxprofit = Math.max(maxprofit,prices[i]-buy_prices);
          }
        }
       return maxprofit; 
    }
}