import java.util.HashMap;

/**
 * User: guoxc
 * Date: 15-2-18
 * Time: 21:20
 */
public class DecodeWays {
    private HashMap<String, Integer> m = new HashMap<String, Integer>();
    public int numDecodings(String s) {
        if(m.containsKey(s)){
            return m.get(s);
        }
        if(s.length() == 0){
            m.put(s,0);
            return 0;
        }else if(s.length() == 1){
            if(s.charAt(0) == '0'){
                m.put(s,0);
                return 0;
            }
            m.put(s,1);
            return 1;
        }else if(s.length() == 2){
            if(s.charAt(0) == '1'){
                if(s.charAt(1) == '0'){
                    m.put(s,1);
                    return 1;
                }
                m.put(s,2);
                return 2;
            }else if(s.charAt(0) == '2'){
                if(s.charAt(1) > '6' || s.charAt(1) == '0'){
                    m.put(s,1);
                    return 1;
                }else{
                    m.put(s,2);
                    return 2;
                }
            }else if(s.charAt(0) == '0') {
                m.put(s,0);
                return 0;
            }else{
                if(s.charAt(1) == '0'){
                    m.put(s,0);
                    return 0;
                }
                m.put(s,1);
                return 1;
            }

        }else{
            if(s.charAt(0) == '0'){
                m.put(s,0);
                return 0;
            }else if(s.charAt(0) == '1'){
                int res = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
                m.put(s,res);
                return res;
            }else if(s.charAt(0) == '2'){
                if(s.charAt(1) > '6' || s.charAt(1) == '0'){
                    int res = numDecodings(s.substring(2));
                    m.put(s, res);
                    return res;
                }else{
                    int res = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
                    m.put(s, res);
                    return res;
                }
            }else{
                int res = numDecodings(s.substring(1));
                m.put(s,res);
                return res;
            }
        }
    }
    public static void test(){
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("1213"));
        System.out.println(d.numDecodings("7206"));
        System.out.println(d.numDecodings("230"));
        System.out.println(d.numDecodings("12120"));
        System.out.println(d.numDecodings("0"));
    }
}
