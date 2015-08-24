/**
 * User: guoxc
 * Date: 15-8-24
 * Time: 17:39
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i = 0; i < n; i += 1){
            res ^= i;
            res ^= nums[i];
        }
        res ^= n;
        return res;
    }
}
