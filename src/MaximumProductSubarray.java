/**
 * Created by Administrator on 2015/3/15.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A){
        int n = A.length;
        int[] dpmax = new int[n];
        int[] dpmin = new int[n];
        int maxA = A[0];
        dpmax[0] = A[0];
        dpmin[0] = A[0];
        for(int i = 1; i < n; i += 1){
            dpmax[i] = max(dpmax[i-1] * A[i], max(dpmin[i-1] * A[i] , A[i]));
            if(dpmax[i] > maxA){
                maxA = dpmax[i];
            }
            dpmin[i] = min(dpmax[i - 1] * A[i], min(dpmin[i - 1] * A[i], A[i]));
        }
        return maxA;
    }
    private int max(int a, int b){
        return a > b ? a : b;
    }
    private int min(int a, int b){
        return a < b ? a : b;
    }
    public static void test(){
        MaximumProductSubarray m = new MaximumProductSubarray();
        System.out.println(m.maxProduct(new int[]{2,3,-2,4}));
    }
}
