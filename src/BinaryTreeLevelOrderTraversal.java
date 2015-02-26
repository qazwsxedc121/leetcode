import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-26
 * Time: 13:35
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> nodeslvl = new ArrayList<TreeNode>();
        nodeslvl.add(root);
        while(nodeslvl.size() > 0){
            List<Integer> l1 = new ArrayList<Integer>();
            List<TreeNode> nodeslvl2 = new ArrayList<TreeNode>();
            for(int i = 0; i < nodeslvl.size(); i += 1){
                TreeNode node = nodeslvl.get(i);
                l1.add(node.val);
                if(node.left != null){
                    nodeslvl2.add(node.left);
                }
                if(node.right != null){
                    nodeslvl2.add(node.right);
                }
            }
            res.add(l1);
            nodeslvl = nodeslvl2;
        }
        return res;
    }
    public static void test(){
        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        System.out.println(b.levelOrder(new TreeNode(1)));
    }
}
