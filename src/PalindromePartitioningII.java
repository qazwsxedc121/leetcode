/**
 * Created by Administrator on 2015/3/9.
 */
public class PalindromePartitioningII {
    private boolean[][] isPal;
    public int minCut(String s) {
        isPal = isPalindrome(s);
        int n = s.length();
        int[] dp = new int[n];
        for(int i = n - 1; i > -1; i -= 1){
            if(isPal[i][n-1]){
                dp[i] = 0;
                continue;
            }
            dp[i] = n;
            for(int j = 0; j < n - i - 1; j += 1){
                if(isPal[i][i+j]) {
                    dp[i] = min(dp[i], 1 + dp[i + j + 1]);
                }
            }
        }
        return dp[0];
    }
    private int min(int a, int b){
        return a < b ? a : b;
    }
    private boolean[][] isPalindrome(String s){
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for(int i = 0; i < n; i += 1){
            res[i][i] = true;
        }
        for(int i = 0; i < n - 1; i += 1){
            res[i][i + 1] = s.charAt(i) == s.charAt(i+1);
        }
        for(int l = 3; l < n + 1; l += 1){
            for(int i = 0; i < n - l + 1; i += 1){
                res[i][i + l - 1] = res[i + 1][i + l - 2] && (s.charAt(i) == s.charAt(i + l - 1));
            }
        }
        return res;
    }
    public static void test(){
        PalindromePartitioningII p = new PalindromePartitioningII();
        System.out.println(p.minCut("ab"));
    }
}
