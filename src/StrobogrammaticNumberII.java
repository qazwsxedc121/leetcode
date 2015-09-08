import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/8.
 */
public class StrobogrammaticNumberII {
    private char rev(char x){
        switch(x){
            case '6':
                return '9';
            case '9':
                return '6';
            default:
                return x;
        }
    }
    private String reverse(String s){
        int n = s.length();
        char[] res = new char[n];
        for(int i = 0; i < n; i += 1){
            res[n-i-1] = rev(s.charAt(i));
        }
        return new String(res);
    }
    private List<String> find(int n){
        List<String> res = new ArrayList<String>();
        if(n == 0){
            res.add("");
            return res;
        }else{
            List<String> res0 = find(n-1);
            for(String si: res0){
                res.add(si + "0");
                res.add(si + "1");
                res.add(si + "6");
                res.add(si + "8");
                res.add(si + "9");
            }
        }
        return res;
    }
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        if(n == 0) return res;
        if(n == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }else if(n % 2 == 0){
            List<String> fl = find(n / 2);
            for(String si : fl){
                if(si.charAt(0) != '0'){
                    res.add(si + reverse(si));
                }
            }
            return res;
        }else{
            List<String> fl = find(n / 2);
            for(String si : fl){
                if(si.charAt(0) != '0'){
                    res.add(si + "0" + reverse(si));
                    res.add(si + "1" + reverse(si));
                    res.add(si + "8" + reverse(si));
                }
            }
            return res;
        }
    }
}
