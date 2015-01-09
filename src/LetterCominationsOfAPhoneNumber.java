import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 16:47
 */
public class LetterCominationsOfAPhoneNumber {
    private HashMap<Integer, char[]> charmap = new HashMap<Integer, char[]>();
    public List<String> letterCombinations(String digits){
        charmap.put(2, new char[]{'a','b','c'});
        charmap.put(3, new char[]{'d','e','f'});
        charmap.put(4, new char[]{'g','h','i'});
        charmap.put(5, new char[]{'j','k','l'});
        charmap.put(6, new char[]{'m','n','o'});
        charmap.put(7, new char[]{'p','q','r','s'});
        charmap.put(8, new char[]{'t','u','v'});
        charmap.put(9, new char[]{'w','x','y','z'});
        return letterCombinationsIter(digits);

    };
    public List<String> letterCombinationsIter(String digits){
        if(digits.length() == 0){
            List<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }
        if(digits.length() == 1){
            int d = digits.toCharArray()[0] - '0';
            if(charmap.containsKey(d)){
                List<String> x = new ArrayList<String>();
                char[] chars = charmap.get(d);
                for(int i = 0; i < chars.length; i += 1){
                    x.add(Character.toString(chars[i]));
                }
                return x;
            }else{
                return (List)new ArrayList<String>();
            }
        }else{
            int d = digits.toCharArray()[0] - '0';
            List<String> l = letterCombinationsIter(digits.substring(1,digits.length()));
            if(l.isEmpty()){
                return letterCombinationsIter(Integer.toString(d));
            }else if(charmap.containsKey(d)){
                List<String> x = new ArrayList<String>();
                char[] chars = charmap.get(d);
                for(int i = 0; i < chars.length; i += 1){
                    for(int j = 0; j < l.size(); j += 1){
                        x.add(""+chars[i]+l.get(j));
                    }
                }
                return x;
            }else{
                return l;
            }
        }

    }
    public static void test(){
        System.out.println(new LetterCominationsOfAPhoneNumber().letterCombinations("213").toString());
    }
}
