import java.util.*;

/**
 * Created by Administrator on 2015/9/16.
 */
public class AlienDictionary {
    Map<Character, Set<Character>> graph;
    Set<Character> cset;
    String resStr;
    Set<Character> visited;
    private boolean insert(char a, char b){
        if(!graph.containsKey(a)){
            graph.put(a, new HashSet<Character>());
        }
        graph.get(a).add(b);
        cset.remove(b);
        return true;
    }
    private void insertWords(List<String> words){
        int n = words.size();
        if(n <= 1) return;
        List<String> toCheck = new ArrayList<String>();
        char cnow = words.get(0).charAt(0);
        if(words.get(0).length() > 1){
            toCheck.add(words.get(0).substring(1));
        }
        for(int i = 1; i < n; i += 1){
            if(words.get(i).charAt(0) == cnow){
                if(words.get(i).length() > 1){
                    toCheck.add(words.get(i).substring(1));
                }
            }else{
                char ncnow = words.get(i).charAt(0);
                insert(cnow, ncnow);
                insertWords(toCheck);
                cnow = ncnow;
                toCheck = new ArrayList<String>();
                if(words.get(i).length() > 1){
                    toCheck.add(words.get(i).substring(1));
                }
            }
        }
        insertWords(toCheck);
    }
    private boolean dfs(char w){
        if(visited.contains(w)) return false;
        visited.add(w);
        if(graph.containsKey(w)) {
            Set<Character> neighbors = graph.get(w);
            for (Character ch : neighbors) {
                if(!dfs(ch)) return false;
            }
        }
        resStr = w + resStr;
        return true;
    }
    public String alienOrder(String[] words) {
        graph = new HashMap<Character, Set<Character>>();
        cset = new HashSet<Character>();
        resStr = "";
        visited = new HashSet<Character>();
        List<String> toCheck = new ArrayList<String>();
        for(int i = 0; i < words.length; i += 1){
            for(int j = 0; j < words[i].length(); j += 1){
                cset.add(words[i].charAt(j));
            }
            if(!words[i].equals("")){
                toCheck.add(words[i]);
            }
        }
        int csetl = cset.size();
        insertWords(toCheck);
        for(Character ch : cset){
            if(!dfs(ch)) return "";
        }
        if(csetl != resStr.length()) return "";
        return resStr;
    }
}
