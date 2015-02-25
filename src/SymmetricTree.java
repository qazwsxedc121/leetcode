import java.util.LinkedList;
import java.util.Queue;


/**
 * User: guoxc
 * Date: 15-2-25
 * Time: 14:14
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        Queue<TreeNode> ql = new LinkedList<TreeNode>();
        Queue<TreeNode> qr = new LinkedList<TreeNode>();
        ql.add(l);
        qr.add(r);
        while(ql.size() > 0 && qr.size() > 0){
            l = ql.poll();
            r = qr.poll();
            if(l == null && r == null){
                continue;
            }else if(l == null || r == null){
                return false;
            }else if(l.val != r.val){
                return false;
            }else{
                ql.add(l.left);
                qr.add(r.right);
                ql.add(l.right);
                qr.add(r.left);
            }
        }
        return ql.isEmpty() && qr.isEmpty();

    }
    public boolean isSymmetricRecusive(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return true;
        }else if(l == null || r == null){
            return false;
        }
        boolean v0 = l.val == r.val;
        boolean v1 = isMirror(l.left, r.right);
        boolean v2 = isMirror(l.right, r.left);
        return v0 && v1 && v2;
    }
}
