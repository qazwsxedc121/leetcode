import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Administrator on 2015/10/2.
 */
public class UniqueWordAbbreviation {
    private HashMap<String, HashSet<String>> set;
    private String abbr(String word){
        int n = word.length();
        if(n <= 2){
            return word;
        }
        char a = word.charAt(0);
        char b = word.charAt(n - 1);
        return "" + a + (n-2) + b;
    }
    public ValidWordAbbr(String[] dictionary) {
        set = new HashMap<String, HashSet<String>>();
        int n = dictionary.length;
        for(int i = 0; i < n; i += 1){
            String abw = abbr(dictionary[i]);
            if(!set.containsKey(abw)){
                set.put(abw, new HashSet<String>());
            }
            set.get(abw).add(dictionary[i]);
        }
    }

    public boolean isUnique(String word) {
        String abw = abbr(word);
        if(set.containsKey(abw)){
            if(set.get(abw).size() >= 2){
                return false;
            }else if(set.get(abw).contains(word)){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
}
