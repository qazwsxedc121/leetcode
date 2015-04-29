import java.util.HashMap;
import java.util.HashSet;

/**
 * User: guoxc
 * Date: 15-4-29
 * Time: 16:52
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> maped = new HashSet<Character>();
        char[] m = s.toCharArray();
        int n = m.length;
        for(int i = 0; i < n; i += 1){
            if(!map.containsKey(m[i])){
                if(maped.contains(t.charAt(i))) return false;
                map.put(m[i], t.charAt(i));
                maped.add(t.charAt(i));
            }
            m[i] = map.get(m[i]);
        }
        return t.equals(new String(m));
    }
    public static void test(){
        System.out.println(new IsomorphicStrings().isIsomorphic("abb","bba"));
        System.out.println(new IsomorphicStrings().isIsomorphic("bbb","bba"));
        System.out.println(new IsomorphicStrings().isIsomorphic("aba","bcb"));

    }
}
