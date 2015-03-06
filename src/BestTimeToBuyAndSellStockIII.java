/**
 * Created by Administrator on 2015/3/6.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        int[] dp1 = new int[n];
        int[] low = new int[n];
        low[0] = prices[0];
        for(int i = 1; i < n ; i += 1){
            low[i] = min(prices[i], low[i - 1]);
            dp1[i] = max(dp1[i-1], prices[i] - low[i]);
        }
        int[] dp2 = new int[n];
        int[] high = new int[n];
        high[n-1] = prices[n-1];
        for(int i = n - 2; i >  -1; i -= 1){
            high[i] = max(prices[i], high[i+1]);
            dp2[i] = max(dp2[i+1], high[i] - prices[i]);
        }
        int maxP = dp1[n-1];
        for(int i = 1; i < n - 1; i += 1){
            maxP = max(maxP, dp1[i] + dp2[i + 1]);
        }
        return maxP;
    }
    private int min(int a, int b){
        return a < b ? a : b;
    }
    private int max(int a, int b){
        return a > b ? a : b;
    }
    public static void test(){
        BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
        System.out.println(b.maxProfit(new int[]{1,3,4,2,5,3,4,9}));
    }
}
