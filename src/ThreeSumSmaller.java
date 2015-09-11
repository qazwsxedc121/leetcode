import java.util.Arrays;

/**
 * Created by Administrator on 2015/9/11.
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for(int i = 0; i < n - 2; i += 1){
            int t0 = target - nums[i];
            int l = i + 1;
            int r = n - 1;
            int sum = nums[l] + nums[r];
            while(l < r){
                if(sum >= t0){
                    r -= 1;
                    sum = nums[l] + nums[r];
                }else{
                    res += r - l;
                    l += 1;
                    sum = nums[l] + nums[r];
                }
            }
        }
        return res;
    }
}
