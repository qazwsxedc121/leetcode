import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-27
 * Time: 11:19
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)return res;
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        nodeList.add(root);
        boolean orderL2R = true;
        while(nodeList.size() > 0){
            List<TreeNode> newNodeList = new ArrayList<TreeNode>();
            List<Integer> l = new ArrayList<Integer>();
            for(int i = 0; i < nodeList.size(); i += 1) {
                TreeNode node = nodeList.get(i);
                if(node.left != null){
                    newNodeList.add(node.left);
                }
                if(node.right != null){
                    newNodeList.add(node.right);
                }
            }

            if(orderL2R){
                for(int i = 0; i < nodeList.size(); i += 1) {
                    TreeNode node = nodeList.get(i);
                    l.add(node.val);
                }
            }else{
                for(int i = nodeList.size() - 1; i > -1; i -= 1){
                    TreeNode node = nodeList.get(i);
                    l.add(node.val);
                }
            }
            orderL2R = !orderL2R;
            res.add(l);
            nodeList = newNodeList;
        }
        return res;
    }
    public static void test(){
        BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(b.zigzagLevelOrder(new TreeNode(1)));
    }
}
