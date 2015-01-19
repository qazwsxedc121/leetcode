/**
 * User: guoxc
 * Date: 15-1-13
 * Time: 16:28
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int patternLength = needle.length();
        if(patternLength == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        for(int i = 0; i < haystack.length()-patternLength+1; i += 1){
            if(haystack.substring(i, i + patternLength).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    public static void test(){
        ImplementStrStr instance = new ImplementStrStr();
        System.out.println(instance.strStr("aaea", "aaea"));
    }
}
