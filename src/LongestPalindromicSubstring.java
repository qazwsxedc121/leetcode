/**
 * Created by Administrator on 2015/1/2.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s){
        char[] arr = s.toCharArray();
        int max = 1;
        int maxi = 0;
        int maxj = 0;
        boolean [][] table = new boolean[1010][1010];
        for(int i = 0; i < arr.length; i += 1){
            table[i][i] = true;
        }
        for(int i = 0; i < arr.length - 1; i += 1){
            if(arr[i] == arr[i+1]){
                table[i][i+1] = true;
                max = 2;
                maxi = i;
                maxj = i+1;
            }
        }
        for(int len = 3; len <= arr.length; len += 1){
            for(int i = 0; i < arr.length - len + 1; i += 1){
                int j = i + len - 1;
                if(arr[i] == arr[j] && table[i+1][j-1]){
                    table[i][j] = true;
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        maxi = i;
                        maxj = j;
                    }
                }
            }
        }
        return s.substring(maxi,maxj+1);
    }
    public boolean isPalindrome(char[] s, int s1, int s2){
        int l = s2 - s1;
        for(int i = s1; i < s1 + (l / 2); i += 1){
            int j = s2 - (i - s1) - 1;
            if(s[i] != s[j]){
                return false;
            }
        }
        return true;
    }
    public static void test(){
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("ccc"));
    }
}
