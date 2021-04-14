package leetcode;

public class BuySellDP {
    public int maxProfit(int[] prices) {
        //DP solution
        /*
        if(prices.length==0) {
            return 0;
        }
        int[] profits = new int[prices.length];
        profits[0] = 0;
        int buyPrice = prices[0];
        for(int i = 1;i <prices.length; i++) {
            profits[i] = Math.max(profits[i-1],prices[i]-buyPrice);
            buyPrice = Math.min(prices[i], buyPrice);
        }
        return profits[prices.length-1];
        */
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price:prices) {
            if(price<minPrice) {
                minPrice = price;
            }
            else if(price-minPrice>maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
