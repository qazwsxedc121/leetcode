import java.util.Set;

/**
 * User: guoxc
 * Date: 15-3-11
 * Time: 16:30
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i < n + 1; i += 1){
            for(int j = 0; j < i; j += 1){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
