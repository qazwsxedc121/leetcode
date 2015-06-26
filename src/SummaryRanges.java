import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-6-26
 * Time: 16:58
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int i = 0;
        List<String> res = new ArrayList<String>();
        while(i < n){
            int l = i;
            while(i + 1 < n && nums[i+1] == nums[i] + 1){
                i += 1;
            }
            int r = i;
            if(l == r){
                res.add("" + nums[l]);
            }else{
                res.add(nums[l] + "->" + nums[r]);
            }
            i += 1;
        }
        return res;
    }
}
