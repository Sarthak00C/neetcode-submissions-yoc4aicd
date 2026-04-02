class Solution {
    public int maxProfit(int[] prices) {
       int pro = 0;
       int minBuy = prices[0];
       
       for(int sell : prices) {
            pro = Math.max(pro, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
       }

       return pro;
    }
}
