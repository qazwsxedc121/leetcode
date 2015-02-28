import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-28
 * Time: 21:12
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        List<TreeNode> l = new ArrayList<TreeNode>();
        l.add(root);
        while(l.size() > 0){
            List<TreeNode> l2 = new ArrayList<TreeNode>();
            List<Integer> ll = new ArrayList<Integer>();
            for(int i = 0; i < l.size(); i += 1){
                TreeNode n = l.get(i);
                ll.add(n.val);
                if(n.left != null){
                    l2.add(n.left);
                }
                if(n.right != null){
                    l2.add(n.right);
                }
            }
            l = l2;
            res.add(0,ll);
        }
        return res;
    }

}
