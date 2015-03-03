/**
 * User: guoxc
 * Date: 15-3-3
 * Time: 13:05
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null) {
            return 1 + minDepth(root.right);
        }else if(root.right == null) {
            return 1 + minDepth(root.left);
        }else{
            int l = minDepth(root.left);
            int r = minDepth(root.right);
            if(l > r){
                return 1 + r;
            }else{
                return 1 + l;
            }
        }
    }
}
