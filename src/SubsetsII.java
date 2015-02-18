import java.util.*;

/**
 * User: guoxc
 * Date: 15-2-18
 * Time: 20:05
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i += 1){
            if(m.containsKey(num[i])){
                m.put(num[i],m.get(num[i]) + 1);
            }else{
                m.put(num[i], 1);
            }
        }
        int m_len = m.keySet().size();
        int[] keys = new int[m_len];
        int[] vals = new int[m_len];
        Iterator<Integer> ir = m.keySet().iterator();
        for(int i = 0; i < m_len; i += 1){
            keys[i] = ir.next();
            vals[i] = m.get(keys[i]);
        }
        int[] bitmap = new int[m_len];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        while(mapincr(bitmap,vals)){
            res.add(pick(bitmap,keys));
        }
        return res;
    }
    private boolean mapincr(int[] bitmap, int[] vals){
        boolean flag = false;
        for(int i = bitmap.length - 1; i > -1; i -= 1){
            if(bitmap[i] < vals[i]){
                bitmap[i] += 1;
                flag = true;
                break;
            }else{
                bitmap[i] = 0;
            }
        }
        return flag;
    }
    private List<Integer> pick(int[] bitmap, int[] keys){
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < bitmap.length; i += 1){
            for(int j = 0; j < bitmap[i]; j += 1) {
                a.add(keys[i]);
            }
        }
        return a;
    }
    public static void test(){
        SubsetsII s = new SubsetsII();
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));
    }
}
