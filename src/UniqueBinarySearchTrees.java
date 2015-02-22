/**
 * User: guoxc
 * Date: 15-2-22
 * Time: 21:19
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i += 1){
            for(int j = 0; j < i; j += 1){
                dp[i] += dp[j] * dp[i- j - 1];
            }
        }
        return dp[n];
    }
    public static void test(){
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(3));
    }
}
