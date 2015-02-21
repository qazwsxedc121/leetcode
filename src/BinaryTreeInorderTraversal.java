import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-21
 * Time: 22:08
 */

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        List<Integer> l = inorderTraversal(root.left);
        if(!l.isEmpty()) {
            for (int i = 0; i < l.size(); i += 1){
                res.add(l.get(i));
            }
        }
        res.add(root.val);
        List<Integer> r = inorderTraversal(root.right);
        if(!r.isEmpty()){
            for(int i = 0; i < r.size(); i += 1){
                res.add(r.get(i));
            }
        }
        return res;

    }
    public static void test(){
        BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
        TreeNode a0 = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        a0.right = a1;
        a1.left = a2;
        System.out.println(b.inorderTraversal(a0));
    }
}
