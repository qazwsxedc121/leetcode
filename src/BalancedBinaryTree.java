/**
 * User: guoxc
 * Date: 15-3-3
 * Time: 10:18
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null){
            return true;
        }else if(root.left == null){
            return depth(root.right) == 1;
        }else if(root.right == null){
            return depth(root.left) == 1;
        }else{
            int l = depth(root.left);
            int r = depth(root.right);
            return l - r < 2 && l - r > -2 && isBalanced(root.left) && isBalanced(root.right);
        }

    }
    private int depth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null){
            return 1 + depth(root.right);
        }else if(root.right == null){
            return 1 + depth(root.left);
        }else{
            int l = depth(root.left);
            int r = depth(root.right);
            if(l > r){
                return 1 + l;
            }else{
                return 1 + r;
            }
        }
    }
}
