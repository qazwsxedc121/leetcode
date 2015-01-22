import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-22
 * Time: 14:36
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return combinationSum2Iter(num, 0, target);
    }
    public List<List<Integer>> combinationSum2Iter(int[] num, int start, int target){
        if(start == num.length){
            return new ArrayList<List<Integer>>();// []
        }else if(start == num.length - 1){
            if(target == num[num.length - 1]){
                List<List<Integer>> res = new ArrayList<List<Integer>>();
                List<Integer> a0  = new ArrayList<Integer>();
                a0.add(num[num.length - 1]);
                res.add(a0);
                return res;// return [[target]]
            }else{
                return new ArrayList<List<Integer>>();// []
            }
        }else{
            int now = num[start];
            if(now > target){
                return new ArrayList<List<Integer>>();
            }else if(now == target){
                List<List<Integer>> res = new ArrayList<List<Integer>>();
                List<Integer> a0  = new ArrayList<Integer>();
                a0.add(num[start]);
                res.add(a0);
                return res;// return [[target]]
            }else{
                List<List<Integer>> res = new ArrayList<List<Integer>>();
                HashSet<String> s = new HashSet<String>();
                List<List<Integer>> a = combinationSum2Iter(num, start + 1, target); // not choose now
                if(!a.isEmpty()){
                    for(int i = 0; i < a.size(); i += 1){
                        res.add(a.get(i));
                        s.add(a.get(i).toString());
                    }
                }
                List<List<Integer>> b = combinationSum2Iter(num, start + 1, target - now); // choose now
                if(!b.isEmpty()){
                    for(int i = 0; i < b.size(); i += 1){
                        b.get(i).add(0, now);
                        String bx = b.get(i).toString();
                        if(!s.contains(bx)){
                            res.add(b.get(i));
                        }
                    }
                }
                return res;
            }
        }


    }
    public static void test(){
        CombinationSumII instance = new CombinationSumII();
        int[] num = new int[]{10,1,2,7,6,1,5};
        System.out.println(instance.combinationSum2(num,8));
    }
}
