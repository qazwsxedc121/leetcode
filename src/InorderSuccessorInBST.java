/**
 * Created by tureoyz on 15-9-22.
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null){
            TreeNode next = p.right;
            while(next.left != null){
                next = next.left;
            }
            return next;
        }
        int t = p.val;
        TreeNode r = root;
        TreeNode ro = null;
        while(r.val != p.val){
            if(r.val < p.val){
                r = r.right;
            }else{
                ro = r;
                r = r.left;
            }
        }
        return ro;
    }
}
