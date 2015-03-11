import java.util.HashMap;

/**
 * https://leetcode.com/discuss/857/constant-space-solution
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int[] x = new int[3];
        x[0] = ~0;
        for(int i = 0; i < A.length; i += 1){
            int t = x[2];
            x[2] = (x[1] & A[i]) | (x[2] & ~A[i]);
            x[1] = (x[0] & A[i]) | (x[1] & ~A[i]);
            x[0] = (t & A[i]) | (x[0] & ~A[i]);
        }
        return x[1];
    }
}
