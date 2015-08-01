/**
 * User: guoxc
 * Date: 15-8-1
 * Time: 21:26
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] amap = new int[26];
        int n0 = s.length();
        int n1 = t.length();
        for(int i = 0; i < n0; i += 1){
            amap[s.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < n1; i += 1){
            amap[t.charAt(i) - 'a'] -= 1;
        }
        for(int i = 0; i < 26; i += 1){
            if(amap[i] != 0){
                return false;
            }
        }
        return true;
    }
}
