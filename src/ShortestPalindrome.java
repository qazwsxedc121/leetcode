/**
 * User: guoxc
 * Date: 15-5-27
 * Time: 17:54
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;
        int f = 0;
        for(int i = n; i > 0; i -= 1){
            if(i % 2 == 0){
                if(isPalE(s, (i/2) - 1)){
                    f = i;
                    break;
                }
            }else{
                if(isPalO(s, i/2)){
                    f = i;
                    break;
                }
            }
        }
        String res = "";
        if(f % 2 == 0){
            res = (new StringBuilder(s.substring(f)).reverse().toString()) + s;
        }else{
            res = (new StringBuilder(s.substring(f)).reverse().toString()) + s;
        }
        return res;
    }
    private boolean isPalE(String s, int m){
        for(int i = 0; i <= m; i += 1){
            if(s.charAt(m-i) != s.charAt(m+i+1)) return false;
        }
        return true;
    }
    private boolean isPalO(String s, int m){
        for(int i = 1; i <= m; i += 1){
            if(s.charAt(m-i) != s.charAt(m+i)) return false;
        }
        return true;
    }

    public static void test() {
        ShortestPalindrome s = new ShortestPalindrome();
        System.out.println(s.shortestPalindrome("ba"));
    }
}
