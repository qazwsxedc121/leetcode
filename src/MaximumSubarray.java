/**
 * Created by Administrator on 2015/1/30.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 1; i < A.length; i += 1){
            sum = sum + A[i];
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
}
