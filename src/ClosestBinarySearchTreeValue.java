/**
 * Created by Administrator on 2015/8/30.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        int now = root.val;
        if(target > now && root.right != null){
            int x = closestValue(root.right, target);
            if(Math.abs(now - target) < Math.abs(x - target))
                return now;
            else
                return x;
        }else if(target < now && root.left != null){
            int x = closestValue(root.left, target);
            if(Math.abs(now - target) < Math.abs(x - target))
                return now;
            else
                return x;
        }
        return now;
    }
}
