/**
 * Created by Administrator on 2015/3/19.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        if(n == 0) return 0;
        int m = dungeon[0].length;
        if(m == 0) return 0;

        int[][] dp = new int[n][m];
        dp[n-1][m-1] = max(1, 1 - dungeon[n-1][m-1]);
        for(int i = n - 2; i >= 0; i -= 1){
            dp[i][m-1] = max(1, dp[i+1][m-1] - dungeon[i][m-1]);
        }
        for(int i = m - 2; i >= 0; i -= 1){
            dp[n-1][i] = max(1, dp[n-1][i+1] - dungeon[n-1][i]);
        }
        for(int i = n - 2; i >= 0; i -= 1){
            for(int j = m - 2; j >= 0; j -= 1){
                dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
    public int max(int a, int b){
        return a > b ? a : b;
    }
    public int min(int a, int b){
        return a < b ? a : b;
    }
    public static void test(){
        int[][] d1 = new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        int[][] d2 = new int[][]{
                {1,-3,3},
                {0,-2,0},
                {-3,-3,-3}
        };
        DungeonGame d = new DungeonGame();
        System.out.println(d.calculateMinimumHP(d1));
    }
}
