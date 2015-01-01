/**
 * Created by Administrator on 2015/1/2.
 */

// fast solution from https://oj.leetcode.com/discuss/13336/shortest-o-n-dp-solution-with-explanations
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){
        char[] sarr = s.toCharArray();
        int[] map = new int[256];
        for(int i = 0; i < 256; i += 1){
            map[i] = -1;
        }
        int m = 0;
        int maxl = 0;
        for(int i = 0; i < sarr.length; i += 1){
            if(map[sarr[i]] + 1 > m) {
                m = map[sarr[i]] + 1;
            }
            map[sarr[i]] = i;
            if(i - m + 1 > maxl){
                maxl = i - m + 1;
            }
        }
        return maxl;
    }
    public int lengthOfLongestSubstring_slow(String s){
        char[] sarr = s.toCharArray();
        int s1 = 0;
        int s2 = sarr.length;
        return iterLengthOfLongestSubstring(sarr,s1,s2);
    }
    public int iterLengthOfLongestSubstring(char[] s, int s1, int s2){
        if(s2 - s1 == 1){
            return 1;
        }
        int[] fres = findSameChar(s,s1,s2);
        if(fres[0] == 0){
            return s2 - s1;
        }else{
            int r1 = iterLengthOfLongestSubstring(s, s1, fres[2]);
            int r2 = iterLengthOfLongestSubstring(s, fres[1] + 1, s2);
            if(r1 >  r2){
                return r1;
            }else{
                return r2;
            }
        }
    }
    public int[] findSameChar(char[] s, int s1, int s2){
        for(int i = s1; i < s2; i += 1){
            for(int j = s2 - 1; j > i; j -= 1){
                if(s[i] == s[j]){
                    return new int[]{1,i,j};
                }
            }
        }
        return new int[]{0,0,0};
    }
    public boolean isRightSubstring(char[] s, int s1, int s2){
        int[] charset = new int[26];
        for(int i = s1; i < s2; i += 1){
            int v = s[i] - 'a';
            if(charset[v] == 1){
                return false;
            }else{
                charset[v] = 1;
            }
        }
        return true;
    }
    public static void test(){
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(a.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
        System.out.println(a.lengthOfLongestSubstring("wcibxubumenmeyatdrmydiajxloghiqfmzhlvihjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfyk"));
    }
}
