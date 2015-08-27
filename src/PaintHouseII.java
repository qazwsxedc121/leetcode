/**
 * Created by Administrator on 2015/8/27.
 */
public class PaintHouseII {
    private int[] big2(int[][] A, int c, int k){
        int[] res = new int[4];
        res[0] = A[c][0];
        res[2] = A[c][0];
        for(int i = 0; i < k; i += 1){
            if(A[c][i] < res[0]){
                res[0] = A[c][i];
                res[1] = i;
            }
        }
        if(res[1] == 0){
            res[2] = A[c][1];
            res[3] = 1;
        }
        for(int i = 0; i < k; i += 1){
            if(i == res[1]) continue;
            if(A[c][i] < res[2]){
                res[2] = A[c][i];
                res[3] = i;
            }
        }
        return res;
    }
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        if(k == 0) return 0;
        int[][] dp = new int[n][k];
        for(int i = 0; i < k; i += 1){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < n; i += 1){
            int[] g = big2(dp, i - 1, k);
            for(int j = 0; j < k; j += 1){
                if(j == g[1]){
                    dp[i][j] = g[2] + costs[i][j];
                }else{
                    dp[i][j] = g[0] + costs[i][j];
                }

            }
        }
        int mincost = 1000000000;
        for(int i = 0; i < k; i += 1){
            mincost = Math.min(mincost, dp[n-1][i]);
        }
        return mincost;
    }
}
