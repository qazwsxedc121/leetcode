import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 17:16
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target){
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < num.length - 3; i += 1){
            if(i > 0 && num[i] == num[i - 1]){
                continue;
            }
            for(int j = i + 1; j < num.length - 2; j += 1){
                if(j > i + 1 && num[j] == num[j - 1]){
                    continue;
                }
                int new_target = target - num[i] - num[j];
                List<int[]> l = twoSum(num, j + 1, new_target);
                for(int k = 0; k < l.size(); k += 1){
                    List<Integer> x = new ArrayList<Integer>();
                    x.add(num[i]);
                    x.add(num[j]);
                    x.add(num[l.get(k)[0]]);
                    x.add(num[l.get(k)[1]]);
                    res.add(x);
                }
            }
        }
        return res;
    }
    public List<int[]> twoSum(int[] num, int l, int target){
        int i = l;
        int j = num.length - 1;
        List<int[]> res = new ArrayList<int[]>();
        while(i < j){
            if(num[i] + num[j] == target){
                res.add(new int[]{i,j});
                i += 1;
                j -= 1;
                while(i < j && num[i] == num[i - 1]){
                    i += 1;
                }
                while(i < j && num[j] == num[j + 1]){
                    j -= 1;
                }
            }else if(num[i] + num[j] < target){
                i += 1;
            }else{
                j -= 1;
            }
        }
        return res;
    }
    public static void test(){
        System.out.println(new FourSum().fourSum(new int[]{1,0,-1,-1,0,-2,2}, 0).toString());
        System.out.println(new FourSum().fourSum(new int[]{0,0,0,0}, 0).toString());
        System.out.println(new FourSum().fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 4).toString());
    }
}
