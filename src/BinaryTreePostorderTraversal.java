import java.util.*;

/**
 * Created by Administrator on 2015/3/12.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.empty()){
            TreeNode top = stack.peek();
            if(visited.contains(top)){
                res.add(top.val);
                stack.pop();
            }else{
                visited.add(top);
                if(top.right != null){
                    stack.push(top.right);
                }
                if(top.left != null){
                    stack.push(top.left);
                }
            }
        }
        return res;
    }
}
