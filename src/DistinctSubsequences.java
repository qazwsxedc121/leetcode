/**
 * Created by Administrator on 2015/3/4.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        int sn = S.length();
        int tn = T.length();
        for(int i = 0; i < sn + 1; i += 1){
            dp[i][0] = 1;
        }
        for(int i = 1; i < tn + 1; i += 1){
            for(int j = i; j < sn + 1; j += 1){
                if(S.charAt(j-1) == T.charAt(i-1)){
                    dp[j][i] = dp[j-1][i-1] + dp[j-1][i];
                }else{
                    dp[j][i] = dp[j-1][i];
                }
            }
        }
        return dp[sn][tn];
    }
    public static void test(){
        DistinctSubsequences d = new DistinctSubsequences();
        System.out.println(d.numDistinct("rrabbbit","rabbit"));
        System.out.println(d.numDistinct("ccc", "c"));
    }
}
