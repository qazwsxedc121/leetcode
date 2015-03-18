/**
 * Created by Administrator on 2015/3/18.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long nl = (long)n;
        long k = 5;
        int res = 0;
        while(nl / k > 0){
            res += nl / k;
            k = k * 5;
        }
        return res;
    }
}
