import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/2/10.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k){
        return combineFrom(n,k,0);
    }
    private List<List<Integer>> combineFrom(int n, int k, int f){
        if(k == 0) return new ArrayList<List<Integer>>();
        if(n - f < k) return new ArrayList<List<Integer>>(); // not enough numbers
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k == 1){
            for(int i = f; i < n; i += 1){
                List<Integer> l = new ArrayList<Integer>();
                l.add(i+1);
                res.add(l);
            }
            return res;
        }else{
            List<List<Integer>> l1 = combineFrom(n, k - 1, f + 1);// pick f
            if(!l1.isEmpty()){
                for(int i = 0; i < l1.size(); i += 1){
                    l1.get(i).add(0, f+1);
                    res.add(l1.get(i));
                }
            }
            List<List<Integer>> l2 = combineFrom(n, k, f + 1);//not pick f;
            if(!l2.isEmpty()){
                for(int i = 0; i < l2.size(); i += 1){
                    res.add(l2.get(i));
                }
            }
            return res;
        }
    }
    public static void test(){
        Combinations c = new Combinations();
        System.out.println(c.combine(4,2));
    }
}
