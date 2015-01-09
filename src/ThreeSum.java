import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-7
 * Time: 17:49
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < num.length - 2; i += 1){
            if(i > 0 && num[i] == num[i-1]) continue;
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){

                int c = num[i] + num[j] + num[k];
                if(c == 0){
                    ArrayList<Integer> x = new ArrayList<Integer>();
                    x.add(num[i]); x.add(num[j]); x.add(num[k]);
                    res.add(x);
                    j += 1;
                    k -= 1;
                    while(j < k && num[j] == num[j - 1]){
                        j += 1;
                    }
                    while(j < k && num[k] == num[k + 1]){
                        k -= 1;
                    }
                }else if(c < 0){
                    j += 1;
                }else{
                    k -= 1;
                }
            }
        }
        return res;
    }

    public static void test(){
        int[] x0 = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        int[] x = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> r = new ThreeSum().threeSum(x);
        for(int i = 0; i < r.size(); i += 1){
            for(int j = 0; j < r.get(i).size(); j += 1){
                System.out.print(r.get(i).get(j)+",");
            }
            System.out.print("\n");
        }
    }
}
