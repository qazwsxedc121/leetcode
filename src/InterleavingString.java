/**
 * User: guoxc
 * Date: 15-3-2
 * Time: 10:00
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        int i = 0;
        while(i < s1.length() && s1.charAt(i) == s3.charAt(i)){
            dp[i+1][0] = true;
            i += 1;
        }
        i = 0;
        while(i < s2.length() && s2.charAt(i) == s3.charAt(i)){
            dp[0][i+1] = true;
            i += 1;
        }

        for(i = 1; i < s1.length() + 1; i += 1){
            for(int j = 1; j < s2.length() + 1; j += 1){
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void test(){
        InterleavingString inter = new InterleavingString();
        System.out.println(inter.isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(inter.isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}
