/**
 * Created by Administrator on 2015/9/14.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if(k == 0) return 0;
        if(n == 0) return 0;
        if(n == 1) return k;
        int res0 = k*(k-1);
        int res1 = k;
        for(int i = 2; i < n; i += 1){
            int temp = res0;
            res0 = (res0 + res1) * (k - 1);
            res1 = temp;
        }
        return res0 + res1;
    }
}
