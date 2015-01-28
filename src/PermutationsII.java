import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-28
 * Time: 17:31
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num.length == 1){
            List<Integer> n = new ArrayList<Integer>();
            n.add(num[0]);
            res.add(n);
            return res;
        }else if(num.length == 0){
            return res;
        }else{
            List<Integer> unique = uniqueIndex(num);
            for(int i = 0; i < unique.size(); i += 1){
                int numAtIndex = num[unique.get(i)];
                int[] excluded = numExcludeIndex(num,unique.get(i));
                List<List<Integer>> permutations = permuteUnique(excluded);
                for(int j = 0; j < permutations.size(); j += 1){
                    permutations.get(j).add(0,numAtIndex);
                    res.add(permutations.get(j));
                }
            }
            return res;
        }
    }
    private List<Integer> uniqueIndex(int[] num){
        ArrayList<Integer> uniqueIndex = new ArrayList<Integer>();
        uniqueIndex.add(0);
        for(int i = 1; i < num.length; i += 1){
            if(num[i] != num[i-1]){
                uniqueIndex.add(i);
            }
        }
        return uniqueIndex;
    }
    private int[] numExcludeIndex(int[] num, int index){
        int[] res = new int[num.length - 1];
        for(int i = 0; i < index; i += 1){
            res[i] = num[i];
        }
        for(int i = index + 1; i < num.length; i += 1){
            res[i-1] = num[i];
        }
        return res;
    }
    public static void test(){
        PermutationsII instance = new PermutationsII();
        List<List<Integer>> res = instance.permuteUnique(new int[]{1,1,2,2});
        System.out.println(res);
    }
}
