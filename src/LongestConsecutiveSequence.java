import java.util.HashMap;

/**
 * Created by Administrator on 2015/3/7.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> m = new HashMap<Integer, Boolean>();
        for(int i = 0; i < num.length; i += 1){
            int x = num[i];
            if(!m.containsKey(x)){
                m.put(x,true);
            }
        }
        int res = 0;
        for(Integer i : m.keySet()){
            if(m.get(i)){
                int c = 0;
                int j = i + 1;
                int k = i - 1;
                while(m.containsKey(j) && m.get(j)){
                    m.put(j, false);
                    j += 1;
                }
                while(m.containsKey(k) && m.get(k)){
                    m.put(k, false);
                    k -= 1;
                }
                c = j - k - 1;
                if(c > res){
                    res = c;
                }
            }
        }
        return res;
    }
    public static void test(){
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
