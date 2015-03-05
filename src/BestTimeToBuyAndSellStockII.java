/**
 * Created by Administrator on 2015/3/5.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices){
        int res = 0;
        for(int i = 1; i < prices.length; i += 1){
            if(prices[i] > prices[i - 1]){
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

}
