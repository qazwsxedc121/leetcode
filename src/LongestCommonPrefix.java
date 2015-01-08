/**
 * User: guoxc
 * Date: 15-1-7
 * Time: 17:31
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }
        int[] lens = new int[strs.length];
        int min_len = strs[0].length();
        int min_index = 0;
        for(int i = 0; i < strs.length; i += 1){
            lens[i] = strs[i].length();
            if(lens[i] < min_len){
                min_len = lens[i];
                min_index = i;
            }
        }
        int r = 0;
        for(int i = 0; i < min_len; i += 1){
            char c = strs[min_index].charAt(i);
            boolean flag = false;
            for(int j = 0; j < strs.length; j += 1){
                if(strs[j].charAt(i) != c){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                r += 1;
            }else{
                break;
            }
        }
        return strs[min_index].substring(0,r);
    }
    public static void test(){
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
            new String[]{"abcd","abcx"}
        ));
    }
}
