/**
 * User: guoxc
 * Date: 15-2-24
 * Time: 19:42
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean res = true;
        if(root.left != null){
            if(root.val > root.left.val) {
                res &= isValidBST(root.left) && smallerThan(root.left, root.val);
            }else{
                return false;
            }
        }
        if(root.right != null){
            if(root.val < root.right.val) {
                res &= isValidBST(root.right) && biggerThan(root.right, root.val);
            }else{
                return false;
            }
        }
        return res;
    }
    private boolean biggerThan(TreeNode root, int v){
        if(root != null && root.val <= v){
            return false;
        }
        if(root == null) {
            return true;
        }
        return biggerThan(root.right, v) && biggerThan(root.left, v);

    }
    private boolean smallerThan(TreeNode root, int v){
        if(root != null && root.val >= v){
            return false;
        }
        if(root == null) {
            return true;
        }
        return smallerThan(root.right, v) && smallerThan(root.left, v);

    }
}
