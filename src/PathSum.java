/**
 * User: guoxc
 * Date: 15-3-3
 * Time: 14:50
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return sum == root.val;
        }else if(root.left == null){
            return hasPathSum(root.right, sum - root.val);
        }else if(root.right == null){
            return hasPathSum(root.left, sum - root.val);
        }else{
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
