/**
 * User: guoxc
 * Date: 15-7-16
 * Time: 23:33
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i = 1; i < n; i += 1){
            left[i] = left[i - 1] * nums[i];
            right[n - i - 1] = right[n - i] * nums[n - i - 1];
        }
        int[] res = new int[n];
        for(int i = 1; i < n - 1; i += 1){
            res[i] = left[i-1] * right[i + 1];
        }
        res[0] = right[1];
        res[n-1] = left[n-2];
        return res;
    }

}
