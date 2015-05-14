/**
 * User: guoxc
 * Date: 15-5-12
 * Time: 12:14
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int min_len = n;
        int i = 0;
        int j = 0;
        int sum_x = 0;
        while (i < n && j < n) {
            while (sum_x < s && j < n) {
                sum_x += nums[j];
                j += 1;
            }

            while (sum_x >= s && i < n) {
                sum_x -= nums[i];
                i += 1;
            }
            if(j - i + 1 < min_len){
                min_len = j - i + 1;
            }
        }
        if(i == 0 && j == n && sum_x < s){
            return 0;
        }
        return min_len;
    }
    public static void test() {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        System.out.println(m.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
