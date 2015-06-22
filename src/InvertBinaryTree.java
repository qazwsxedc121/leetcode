/**
 * Created by Administrator on 2015/6/12.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
