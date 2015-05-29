import java.util.HashMap;

/**
 * User: guoxc
 * Date: 15-5-29
 * Time: 16:40
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer>m = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i += 1){
            if(m.containsKey(nums[i])){
                if(i - m.get(nums[i]) > k){
                    m.put(nums[i], i);
                }else{
                    return true;
                }
            }else{
                m.put(nums[i], i);
            }
        }

        return false;
    }
}
