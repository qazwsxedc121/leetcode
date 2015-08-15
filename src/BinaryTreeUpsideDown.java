/**
 * User: guoxc
 * Date: 15-8-15
 * Time: 10:00
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)return null;
        if(root.left == null && root.right == null) return root;
        else{
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = null;
            root.right = null;
            TreeNode newRoot = upsideDownBinaryTree(l);
            TreeNode p = newRoot;
            while(p.right != null){
                p = p.right;
            }
            p.right = root;
            p.left = r;
            return newRoot;
        }
    }
}
