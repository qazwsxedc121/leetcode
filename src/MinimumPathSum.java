/**
 * Created by Administrator on 2015/2/7.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid){
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        int[][] dp = new int[m][n];
        int c = 0;
        for(int i = 0; i < m; i += 1){
            c += grid[m-1-i][n-1];
            dp[m-1-i][n-1] = c;
        }
        c = 0;
        for(int i = 0; i < n; i += 1){
            c += grid[m-1][n-1-i];
            dp[m-1][n-1-i] = c;
        }
        for(int i = 1; i < m; i += 1){
            for(int j = 1; j < n; j += 1){
                int t = grid[m-1-i][n-1-j];
                if(dp[m-i][n-1-j] > dp[m-1-i][n-j]){
                    dp[m-i-1][n-j-1] = dp[m-1-i][n-j] + t;
                }else{
                    dp[m-i-1][n-j-1] = dp[m-i][n-j-1] + t;
                }
            }
        }
        return dp[0][0];
    }
    public static void test(){
        MinimumPathSum instance = new MinimumPathSum();
        int[][] g = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(instance.minPathSum(g));
    }
}
