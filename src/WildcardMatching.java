/**
 * Created by Administrator on 2015/1/25.
 */

//solution from https://oj.leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
public class WildcardMatching {
    public boolean isMatch(String s, String p){
        String sStr = s;
        String pStr = p;
        int sPointer = 0;
        int pPointer = 0;
        int lastStar = -1;
        int jumpStart = 0;
        while(sPointer < s.length()){
            char sChar = sStr.charAt(sPointer);
            if(pPointer < p.length() && (pStr.charAt(pPointer) == '?' || sChar == pStr.charAt(pPointer))){
                sPointer += 1;
                pPointer += 1;
            }else if(pPointer < p.length() && pStr.charAt(pPointer) == '*'){
                lastStar = pPointer;
                jumpStart = sPointer;
                pPointer += 1;
            }else if(lastStar != -1){
                pPointer = lastStar + 1;
                jumpStart += 1;
                sPointer = jumpStart;

            }else{
                return false;
            }
        }
        while(pPointer < p.length() && pStr.charAt(pPointer) == '*'){
            pPointer += 1;
        }
        return pPointer == pStr.length();




    }

    public static void test(){
        WildcardMatching instance = new WildcardMatching();
        System.out.println(instance.isMatch("aa", "a"));
        System.out.println(instance.isMatch("aa","*"));
        System.out.println(instance.isMatch("ab","?*"));
        System.out.println(instance.isMatch("aab","c*a*b"));
        System.out.println(instance.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
}
