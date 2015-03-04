import java.util.LinkedList;
import java.util.Queue;

/**
 * User: guoxc
 * Date: 14-10-9
 * Time: 16:48
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
    public String toString(){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String res = "\"";
        q.add(this);
        while(q.size() > 0){
            TreeNode node = q.poll();
            if(node == null){
                res += "#,";
            }else{
                res +=  node.val + ",";
                q.add(node.left);
                q.add(node.right);
            }
        }
        res = res.substring(0,res.length()-1) + "\"";
        return res;
    }
}
