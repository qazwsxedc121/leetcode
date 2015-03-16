import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
public class MaximumGap {
    public int maximumGap(int[] num){
        int n = num.length;
        if(n <= 1) return 0;
        int k = 1 << 30;
        List<Integer> l = new LinkedList<Integer>();
        for(int i = 0; i < n; i += 1){
            l.add(num[i]);
        }
        return maxiGap(l, k);
    }
    private int maxiGap(List<Integer> num, int k){
        int n = num.size();
        if(k == 1){
            return 0;
        }
        if(n <= 1){
            return 0;
        }else if(n == 2){
            return Math.abs(num.get(0) - num.get(1));
        }
        List<Integer> left = new LinkedList<Integer>();
        List<Integer> right = new LinkedList<Integer>();
        int l_max = Integer.MIN_VALUE;
        int r_min = Integer.MAX_VALUE;
        for(int x : num){
            if(x < k){
                l_max = max(l_max, x);
                left.add(x);
            }else{
                r_min = min(r_min, x);
                right.add(x - k);
            }
        }
        if(left.isEmpty()){
            return maxiGap(right, k >> 1);
        }else if(right.isEmpty()){
            return maxiGap(left, k >> 1);
        }
        int lm = maxiGap(left, k >> 1);
        int rm = maxiGap(right, k >> 1);
        int lrm = r_min - l_max;
        return max(lrm, max(lm,rm));
    }
    private int max(int a, int b){
        return a > b ? a : b;
    }
    private int min(int a, int b){
        return a < b ? a : b;
    }
    public static void test(){
        MaximumGap m = new MaximumGap();
        System.out.println(m.maximumGap(new int[]{15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740}));
    }
}
