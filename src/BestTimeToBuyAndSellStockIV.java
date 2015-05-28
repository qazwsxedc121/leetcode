/**
 * Created by Administrator on 2015/5/28.
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        if(k > n/2) return solve(prices);
        int[][] dp = new int[k+1][n];
        for(int i = 1; i <= k; i += 1){
            int t = -prices[0];
            for(int j = 1; j < n; j += 1){
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+t);
                t = Math.max(t, dp[i-1][j-1] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
    private int solve(int[] prices){
        int n = prices.length;
        int res = 0;
        for(int i = 1; i < n; i += 1){
            if(prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
