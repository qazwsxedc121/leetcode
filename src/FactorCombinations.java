import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/5.
 */
public class FactorCombinations {
    private List<List<Integer>> getFactorFrom(int start, int n){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(start > n) return res;
        List<Integer> resSelf = new ArrayList<Integer>();
        resSelf.add(n);
        res.add(resSelf);
        for(int i = start; i < n; i += 1){
            if(n % i != 0) continue;
            List<List<Integer>> res0 = getFactorFrom(i, n / i);
            for(int j = 0; j < res0.size(); j += 1){
                res0.get(j).add(0, i);
                res.add(res0.get(j));
            }
        }
        return res;
    }
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = getFactorFrom(2, n);
        if(res.size() > 0) res.remove(0);
        return res;
    }
}
