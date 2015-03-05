import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/5.
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root){
        List<TreeNode> order = inorderTraversal(root);
        List<Integer> reverseIndex = new ArrayList<Integer>();
        for(int i = 0; i < order.size() - 1; i += 1){
            if(order.get(i).val > order.get(i + 1).val){
                reverseIndex.add(i);
            }
        }
        if(reverseIndex.size() == 1){
            int k = reverseIndex.get(0);
            swap(order.get(k), order.get(k+1));
        }else if(reverseIndex.size() == 2){
            int k0 = reverseIndex.get(0);
            int k1 = reverseIndex.get(1);
            swap(order.get(k0), order.get(k1+1));
        }
        return;

    }
    private void swap(TreeNode swap1, TreeNode swap2){
        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
    }
    private List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (root.left == null && root.right == null) {
            res.add(root);
            return res;
        } else if (root.right == null) {
            List<TreeNode> l = inorderTraversal(root.left);
            l.add(root);
            return l;
        } else if (root.left == null) {
            List<TreeNode> r = inorderTraversal(root.right);
            r.add(0, root);
            return r;
        } else {
            List<TreeNode> l = inorderTraversal(root.left);
            List<TreeNode> r = inorderTraversal(root.right);
            l.add(root);
            for (int i = 0; i < r.size(); i += 1) {
                l.add(r.get(i));
            }
            return l;
        }
    }
    public static void test(){
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        t0.left = t1;
        r.recoverTree(t0);
    }
}
