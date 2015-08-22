//solution from https://leetcode.com/discuss/52905/my-16ms-c-dp-solution-with-short-explanation

/**
 * User: guoxc
 * Date: 15-8-21
 * Time: 22:29
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        dp[0] = 1;
        for(int i = 1; i < n; i += 1){
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2) p2 += 1;
            if(dp[i] == dp[p3] * 3) p3 += 1;
            if(dp[i] == dp[p5] * 5) p5 += 1;
        }
        return dp[n-1];
    }

    public static void test() {
        System.out.println(new UglyNumberII().nthUglyNumber(306));
    }
}