import java.util.HashMap;

/**
 * User: guoxc
 * Date: 15-2-13
 * Time: 22:57
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> curve = string2curve(T);
        HashMap<Character, Integer> curve0 = (HashMap<Character, Integer>) curve.clone();
        int size = 0;
        for(Character c : curve.keySet()){
            size += curve.get(c);
        }
        char[] schars = S.toCharArray();
        int x = 0;
        int end0 = -1;
        for(int i = 0; i < schars.length; i += 1){
            if(curve.containsKey(schars[i])){
                int c = curve.get(schars[i]);
                if(c > 0){
                    curve.put(schars[i], c - 1);
                    x += 1;
                }
            }
            if(x == size){
                end0 = i;
                break;
            }
        }
        if(end0 == -1) return "";
        int l = 0;
        int r = end0;
        for(int i = 0; i < r + 1; i += 1){
            if(curve.containsKey(schars[i])){
                int c = curve.get(schars[i]);
                curve.put(schars[i], c + 1);
            }
        }
        while(l < r + 1){
            if(curve0.containsKey(schars[l])){
                if(curve.get(schars[l]) > curve0.get(schars[l])){
                    curve.put(schars[l], curve.get(schars[l]) - 1);
                    l += 1;
                }else{
                    break;
                }
            }else{
                l += 1;
            }
        }
        int min = r - l + 1;
        int l_min = l;
        int r_min = r;
        while(r < schars.length){
            char missing = ' ';
            while(l < r + 1){
                if(curve0.containsKey(schars[l])){
                    if(curve.get(schars[l]) > curve0.get(schars[l])){
                        curve.put(schars[l], curve.get(schars[l]) - 1);
                        l += 1;
                    }else{
                        curve.put(schars[l], curve.get(schars[l]) - 1);
                        missing = schars[l];
                        break;
                    }
                }else{
                    l += 1;
                }
            }
            if(missing == ' ') break;
            if(r - l + 1 < min){
                min = r - l + 1;
                l_min = l;
                r_min = r;
            }
            l += 1;
            r += 1;
            while(r < schars.length){
                if(curve0.containsKey(schars[r])){
                    curve.put(schars[r], curve.get(schars[r]) + 1);
                    if(schars[r] == missing){
                        break;
                    }
                    r += 1;
                }else{
                    r += 1;
                }
            }



        }
        return S.substring(l_min, r_min + 1);
    }
    private HashMap<Character, Integer> string2curve(String T){
        HashMap<Character, Integer> curve = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i += 1){
            if(curve.containsKey(T.charAt(i))){
                int c = curve.get(T.charAt(i));
                curve.put(T.charAt(i), c + 1);
            }else{
                curve.put(T.charAt(i), 1);
            }
        }
        return curve;
    }
    public static void test(){
        MinimumWindowSubstring m = new MinimumWindowSubstring();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        System.out.println(m.minWindow(s,t));
        System.out.println(m.minWindow("cabefgecdaecf", "cae"));
    }
}
