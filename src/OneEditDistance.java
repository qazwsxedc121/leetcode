/**
 * Created by Administrator on 2015/9/1.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()){
            int n = s.length();
            int c = 0;
            for(int i = 0; i < n; i += 1){
                if(s.charAt(i) != t.charAt(i)) c += 1;
            }
            return c == 1;
        }
        if(s.length() < t.length()){
            String temp = s;
            s = t;
            t = temp;
        }
        if(s.length() - t.length() == 1){
            int n = s.length();
            if(n == 1) return true;
            int j = 0;
            for(int i = 0; i < n; i += 1){
                if(j < n - 1 && s.charAt(i) == t.charAt(j)){
                    j += 1;
                }
            }
            return j == n - 1;
        }else{
            return false;
        }
    }
}
