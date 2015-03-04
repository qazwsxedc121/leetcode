/**
 * User: guoxc
 * Date: 15-3-3
 * Time: 18:05
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(!isAnagram(s1,s2)){
            return false;
        }

        int n = s1.length();
        if(n == 1){
            return s1.charAt(0) == s2.charAt(0);
        }
        for(int i = 1; i < n; i += 1){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            if(isScramble(s11, s21) && isScramble(s12, s22)){
                return true;
            }
            s21 = s2.substring(0, n - i);
            s22 = s2.substring(n-i);
            if(isScramble(s11, s22) && isScramble(s12, s21)){
                return true;
            }
        }
        return false;
    }
    private boolean isAnagram(String s1, String s2){
        int[] chars = new int[256];
        for(int i = 0; i < s1.length(); i += 1){
            chars[s1.charAt(i)] += 1;
            chars[s2.charAt(i)] -= 1;
        }
        for(int i = 0; i < 256; i += 1){
            if(chars[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void test(){
        ScrambleString s = new ScrambleString();
        System.out.println(s.isScramble("1234","4321"));
        System.out.println(s.isScramble("1234","2413"));
    }
}
