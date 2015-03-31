/**
 * Created by Administrator on 2015/3/31.
 */
public class HouseRobber {
    public int rob(int[] num){
        int n = num.length;
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[n-1] = num[n-1];
        for(int i = n - 2; i > -1; i -= 1){
            dp[i] = Math.max(num[i] + dp[i + 2], dp[i+1]);
        }
        return dp[0];
    }

    public static void test(){
        HouseRobber h = new HouseRobber();
        System.out.println(h.rob(new int[]{1,2,3,4,2}));
    }
}
