/**
 * Created by Administrator on 2015/2/9.
 */
public class EditDistance {
    public int minDistance(String word1, String word2){
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1 == 0) return l2;
        if(l2 == 0) return l1;
        int[][] dp = new int[l1][l2];
        if(word1.charAt(0) == word2.charAt(0)){
            dp[0][0] = 0;
        }else{
            dp[0][0] = 1;
        }
        for(int i = 1; i < l2; i += 1){
            if(word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = i;
            }else{
                dp[0][i] = dp[0][i-1] + 1;
            }
        }
        for(int i = 1; i < l1; i += 1){
            if(word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = i;
            }else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for(int i = 1; i < l1; i += 1){
            for(int j = 1; j < l2; j += 1){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]) + 1;
                }
            }
        }
        return dp[l1-1][l2-1];
    }
    private int min(int a, int b, int c){
        if(a < b && a < c){
            return a;
        }else if(b <= a && b < c){
            return b;
        }else{
            return c;
        }
    }
    public static void test(){
        EditDistance instance = new EditDistance();
        System.out.println(instance.minDistance("abc","ace"));
        System.out.println(instance.minDistance("abc","bcd"));
        System.out.println(instance.minDistance("ab","a"));
        System.out.println(instance.minDistance("bbbbb","b"));
    }
}
