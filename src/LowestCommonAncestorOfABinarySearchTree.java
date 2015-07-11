/**
 * User: guoxc
 * Date: 15-7-11
 * Time: 22:27
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }
        if(p.val == q.val){
            return p;
        }
        if(p == root || q == root){
            return root;
        }
        if(p.val < root.val && root.val < q.val){
            return root;
        }else if(root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
