import java.util.HashMap;

/**
 * Created by Administrator on 2015/6/1.
 */
public class ContainsDuplicateIII {
    class BSTNode{
        BSTNode left;
        BSTNode right;
        int val;
        public BSTNode(int v){
            val = v;
        }
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        BSTNode root = new BSTNode(nums[0]);
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length; i += 1){
            BSTNode p0 = root;
            BSTNode p = root;
            while(p != null){
                if(Math.abs((long)p.val - (long)nums[i]) <= (long)t && i - map.get(p.val) <= k){
                    return true;
                }
                if(p.val == nums[i]){
                    map.put(p.val, i);
                    break;
                }else if(nums[i] < p.val){
                    p0 = p;
                    p = p.left;
                }else {
                    p0 = p;
                    p = p.right;
                }
            }
            if(p == null){
                map.put(nums[i], i);
                if(nums[i] < p0.val){
                    p0.left = new BSTNode(nums[i]);
                }else {
                    p0.right = new BSTNode(nums[i]);
                }
            }
        }
        return false;
    }
    public static void test(){
        ContainsDuplicateIII c = new ContainsDuplicateIII();
        System.out.println(c.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
    }
}
