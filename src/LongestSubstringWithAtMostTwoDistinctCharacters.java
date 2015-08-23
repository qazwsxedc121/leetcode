/**
 * User: guoxc
 * Date: 15-8-23
 * Time: 21:54
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] chars = new int[256];
        int l = 0;
        int r = 0;
        int len = r - l;
        int n = s.length();
        int charsl = 0;
        while(r < n){
            char c = ' ';
            while(r < n && charsl < 3){
                c = s.charAt(r);
                if(chars[c] == 0 && charsl == 2){
                    break;
                }else if(chars[c] == 0){
                    charsl += 1;
                }
                chars[c] += 1;
                r += 1;
            }
            if(r - l > len) len = r - l;
            while(charsl == 2 && l < r){
                c = s.charAt(l);
                chars[c] -= 1;
                if(chars[c] == 0){
                    charsl -= 1;
                }
                l += 1;
            }
        }
        return len;
    }
}
