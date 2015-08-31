/**
 * Created by Administrator on 2015/8/31.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int a0 = -1;
        int b0 = -1;
        int res = n + 1;
        for(int i = 0; i < n; i += 1){
            if(words[i].equals(word1)){
                a0 = i;
                if(b0 != -1){
                    res = Math.min(res, Math.abs(b0 - a0));
                }
            }else if(words[i].equals(word2)){
                b0 = i;
                if(a0 != -1){
                    res = Math.min(res, Math.abs(b0 - a0));
                }
            }
        }
        return res;
    }
}
