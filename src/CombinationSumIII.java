import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/24.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combi(1,k,n);
    }
    private List<List<Integer>> combi(int f, int k, int n){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n < f) return res;
        if(k == 1){
            if(f <= n && n <= 9){
                List<Integer> l1 = new ArrayList<Integer>();
                l1.add(n);
                res.add(l1);
                return res;
            }else{
                return res;
            }
        }else{
            List<List<Integer>> res1 = combi(f+1, k - 1, n - f);
            if(!res1.isEmpty()){
                for(List<Integer> l : res1){
                    l.add(0, f);
                    res.add(l);
                }
            }
            List<List<Integer>> res2 = combi(f+1, k, n);
            for(List<Integer> l : res2){
                res.add(l);
            }
            return res;
        }
    }
}
