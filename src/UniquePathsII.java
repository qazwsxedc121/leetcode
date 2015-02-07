/**
 * Created by Administrator on 2015/2/7.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i += 1){
            if(obstacleGrid[m-i-1][n-1] == 0){
                dp[m-i-1][n-1] = 1;
            }else{
                break;
            }
        }
        for(int i = 0; i < n; i += 1){
            if(obstacleGrid[m-1][n-1-i] == 0){
                dp[m-1][n-1-i] = 1;
            }else{
                break;
            }
        }
        for(int i = 1; i < m; i += 1){
            for(int j = 1; j < n; j += 1){
                if(obstacleGrid[m-1-i][n-1-j] == 0){
                    dp[m-1-i][n-1-j] = dp[m-1-i][n-j] + dp[m-i][n-1-j];
                }else{
                    continue;
                }
            }
        }
        return dp[0][0];

    }
    public static void test(){
        UniquePathsII instance = new UniquePathsII();
        int res = instance.uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        });
        System.out.println(res);
    }
}
