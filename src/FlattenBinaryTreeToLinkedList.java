/**
 * User: guoxc
 * Date: 15-3-3
 * Time: 16:59
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenWithEnd(root);
    }
    private TreeNode flattenWithEnd(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null){
            return root;
        }else if(root.left == null){
            return flattenWithEnd(root.right);
        }else if(root.right == null){
            TreeNode res = flattenWithEnd(root.left);
            root.right = root.left;
            root.left = null;
            return res;
        }else{
            TreeNode leftEnd = flattenWithEnd(root.left);
            TreeNode rightBegin = root.right;
            TreeNode res = flattenWithEnd(root.right);
            root.right = root.left;
            root.left = null;
            leftEnd.right = rightBegin;
            return res;
        }
    }
}
