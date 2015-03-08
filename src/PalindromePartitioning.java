import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/8.
 */
public class PalindromePartitioning {
    private boolean[][] isPal;
    public List<List<String>> partition(String s){
        isPal = isPalindrome(s);
        return partitionIter(s, 0);
    }
    private List<List<String>> partitionIter(String s, int l){
        List<List<String>> res = new ArrayList<List<String>>();
        if(l == s.length()) return res;
        if(isPal[l][s.length() - 1]){
            List<String> resOne = new ArrayList<String>();
            resOne.add(s.substring(l));
            res.add(resOne);
        }
        for(int i = l ; i < s.length() - 1; i += 1) {
            if (isPal[l][i]) {
                String t = s.substring(l, i + 1);
                List<List<String>> sub = partitionIter(s, i + 1);
                for (int j = 0; j < sub.size(); j += 1) {
                    sub.get(j).add(0, t);
                    res.add(sub.get(j));
                }
            }
        }
        return res;
    }
    private boolean[][] isPalindrome(String s){
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for(int i = 0; i < n; i += 1){
            res[i][i] = true;
        }
        for(int i = 1; i < n - 1; i += 1){
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)){
                res[l][r] = true;
                l -= 1;
                r += 1;
            }
        }
        for(int i = 0; i < n - 1; i += 1){
            int l = i;
            int r = i + 1;
            while(l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)){
                res[l][r] = true;
                l -= 1;
                r += 1;
            }
        }
        return res;
    }
    public static void test(){
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aa"));
    }
}
