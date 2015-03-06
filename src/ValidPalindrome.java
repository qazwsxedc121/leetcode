/**
 * Created by Administrator on 2015/3/6.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return true;
        int l = 0;
        int r = n - 1;
        while(l < r){
            char cl = s.charAt(l);
            if(!isNumChar(cl)){
                l += 1;
                continue;
            }
            cl = toLowerCase(cl);
            char cr = s.charAt(r);
            if(!isNumChar(cr)){
                r -= 1;
                continue;
            }
            cr = toLowerCase(cr);
            if(cl == cr){
                l += 1;
                r -= 1;
            }else{
                return false;
            }
        }
        return true;
    }
    private boolean isNumChar(char c){
        return (c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a') || (c <= '9' && c >= '0');
    }
    private char toLowerCase(char c){
        if(c <= 'Z' && c >= 'A'){
            return (char)(c - 'A' + 'a');
        }
        return c;
    }
}
