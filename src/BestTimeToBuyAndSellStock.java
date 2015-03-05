/**
 * Created by Administrator on 2015/3/5.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices){
        int n = prices.length;
        if(n <= 1) return 0;
        int profit = 0;
        int low = 0;
        low = prices[0];
        for(int i = 1; i < n; i += 1){
            low = low < prices[i] ? low : prices[i];
            profit = max(profit, prices[i] - low);
        }
        return profit;
    }
    private int max(int a, int b){
        return a > b ? a : b;
    }
    public static void test(){
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(new int[]{1,2,4}));
    }
}
