/**
 * Created by Administrator on 2015/9/23.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int x = (int) Math.floor(Math.sqrt(n));
        if( x * x == n) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i <= x; i += 1){
            dp[(i*i) - 1] = 1;
        }
        for(int i = 1; i < n; i += 1){
            if(dp[i] == 1) continue;
            int mini = i + 1;
            for(int j = 0; j < (i / 2) + 1; j += 1){
                mini = Math.min(mini, dp[j] + dp[i-j-1]);
            }
            dp[i] = mini;
        }
        return dp[n-1];
    }
}
