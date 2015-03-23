import java.util.HashMap;

/**
 * User: guoxc
 * Date: 15-3-17
 * Time: 15:09
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        int n = num.length;
        if(n == 1) return num[0];
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i += 1){
            if(m.containsKey(num[i])){
                int c = m.get(num[i]);
                m.put(num[i], c + 1);
                if(c + 1 > n / 2){
                    return num[i];
                }
            }else{
                m.put(num[i], 1);
            }
        }
        return 0;
    }
}
