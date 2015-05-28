import java.util.HashSet;

/**
 * User: guoxc
 * Date: 15-5-25
 * Time: 15:48
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i += 1){
            if(s.contains(nums[i])){
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}
