import java.util.*;

/**
 * User: guoxc
 * Date: 15-3-11
 * Time: 16:47
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dpx = new boolean[n+1];

        List<List<String>> dp = new ArrayList<List<String>>();
        List<String> head = new ArrayList<String>();
        head.add("");
        dp.add(head);
        int max_l = 0;
        for(String w : dict){
            if(w.length() > max_l){
                max_l = w.length();
            }
        }
        dpx[0] = true;
        for(int i = 1; i < n + 1; i += 1){
            for(int j = max(i - max_l, 0); j < i; j += 1){
                String sub = s.substring(j, i);
                if(dpx[j] && dict.contains(sub)){
                    dpx[i] = true;
                    break;
                }
            }
        }
        if(!dpx[n]){
            return new ArrayList<String>();
        }
        for(int i = 1; i < n + 1; i += 1){
            List<String> cell = new ArrayList<String>();
            for(int j = max(i - max_l, 0);j < i; j += 1){
                String sub = s.substring(j, i);
                if(dpx[j] && dict.contains(sub)){
                    List<String> first = dp.get(j);
                    for(String firstS: first){
                        cell.add(firstS + " " + sub);
                    }
                }
            }
            dp.add(cell);
        }
        List<String> res = new ArrayList<String>();
        List<String> resN = dp.get(n);
        for(int i = 0; i < resN.size(); i += 1){
            res.add(resN.get(i).substring(1));
        }
        return res;
    }
    private int max (int a, int b){
        return a > b ? a : b;
    }
    public static void test(){
        WordBreakII w = new WordBreakII();
        String[] dict_a = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        HashSet<String> dict = new HashSet<String>();
        for(int i = 0; i < dict_a.length; i += 1){
            dict.add(dict_a[i]);
        }
        System.out.println(w.wordBreak("aaaaaaaaaaaaa",dict));
    }

}
