import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-21
 * Time: 18:34
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] r = removeDuplicate(candidates);
        return combinationSumIter(r, target);
    }
    public List<List<Integer>> combinationSumIter(int[] candidates, int target){
        if(target < 0) return new ArrayList<List<Integer>>();
        if(candidates.length == 0){
            return new ArrayList<List<Integer>>();
        }else if(candidates.length == 1){
            if(target % candidates[0] == 0){
                List<List<Integer>> res = new ArrayList<List<Integer>>();
                List<Integer> r0 = new ArrayList<Integer>();
                for(int i = 0; i < target / candidates[0]; i += 1){
                    r0.add(candidates[0]);
                }
                res.add(r0);
                return res;
            }else{
                return new ArrayList<List<Integer>>();
            }
        }else{
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<List<Integer>> a = combinationSumIter(candidates, target - candidates[0]);
            if(!a.isEmpty()){
                for(int i = 0; i < a.size(); i += 1){
                    a.get(i).add(0,candidates[0]);
                    res.add(a.get(i));
                }
            }
            List<List<Integer>> b= combinationSumIter(subIntArray(candidates, 1, candidates.length), target);
            if(!b.isEmpty()){
                for(int i = 0; i < b.size(); i += 1){
                    res.add(b.get(i));
                }
            }
            return res;
        }
    }
    public int[] subIntArray(int[] array, int l, int r){
        int[] res = new int[r-l];
        for(int i = l; i < r; i += 1){
            res[i-l] = array[i];
        }
        return res;
    }
    public int[] removeDuplicate(int[] source){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(source[0]);
        for(int i = 1; i < source.length; i += 1){
            if(source[i] != source[i-1]){
                l.add(source[i]);
            }
        }
        int[] res = new int[l.size()];
        for(int i = 0; i < res.length; i += 1){
            res[i] = l.get(i);
        }
        return res;
    }


    public static void test(){
        CombinationSum instance = new CombinationSum();
        System.out.println(instance.combinationSum(new int[]{2,3,6,7},7));
        System.out.println(instance.combinationSum(new int[]{92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73},310));
    }
}
