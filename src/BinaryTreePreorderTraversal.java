import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/3/12.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        TreeNode p = root;
        List<Integer> res = new ArrayList<Integer>();
        if(p == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(p);
        while(!stack.empty()){
            TreeNode top = stack.pop();
            res.add(top.val);
            if(top.right != null){
                stack.push(top.right);
            }
            if(top.left != null){
                stack.push(top.left);
            }
        }
        return res;
    }
}
