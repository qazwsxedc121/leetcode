import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-16
 * Time: 15:39
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        int l_length = L[0].length();
        int ll_length = l_length*L.length;
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i += 1){
            map.put(L[i],i);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < S.length()-ll_length+1; i += 1) {
            String sub = S.substring(i, i + ll_length);
            if (isSubstring(sub, L, map)) {
                res.add(i);
            }
        }
        return res;
    }
    public boolean isSubstring(String sub, String[] L, HashMap<String, Integer> map){
        int l_length = L[0].length();

        boolean[] bitmap = new boolean[L.length];
        for(int i = 0; i < sub.length() / l_length; i += 1){
            String toCompare = sub.substring(i * l_length, (i+1) * l_length);
            if(map.containsKey(toCompare)){
                boolean flag = false;
                for(int j = 0; j < bitmap.length; j += 1){
                    if(bitmap[j]) continue;
                    if(L[j].equals(toCompare) && !bitmap[j]){
                        bitmap[j] = true;
                        flag = true;
                        break;
                    }
                }
                if(!flag) return false;

            }else{
                return false;
            }
        }
        return true;
    }
    public static void test(){
        SubstringWithConcatenationOfAllWords instance = new SubstringWithConcatenationOfAllWords();
//        System.out.println(instance.findSubstring("abcddcba", new String[]{"a","b","c"}));
        System.out.println(instance.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
