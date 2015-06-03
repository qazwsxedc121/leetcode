/**
 * Created by Administrator on 2015/6/3.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        if(m == 0) return 0;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0; i < m; i += 1){
            if(matrix[n-1][i] == '1') {
                dp[n-1][i] = 1;
                max = 1;
            }
        }
        for(int i = 0; i < n; i += 1){
            if(matrix[i][m-1] == '1'){
                dp[i][m-1] = 1;
                max = 1;
            }
        }
        for(int i = n - 2; i >= 0; i -= 1){
            for(int j = m - 2; j >= 0; j -= 1){
                if(matrix[i][j] == '0'){
                    continue;
                }
                int x = 0;
                int y = 0;
                while(j + x < m && matrix[i][j+x] == '1'){
                    x += 1;
                }
                x -= 1;
                while(i + y < n && matrix[i+y][j] == '1'){
                    y += 1;
                }
                y -= 1;
                dp[i][j] = Math.min(dp[i+1][j+1] + 1, Math.min(x+1,y+1));
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
