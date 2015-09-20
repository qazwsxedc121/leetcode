import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/9/20.
 */
public class ClosestBinarySearchTreeValueII {
    Stack<Integer> pre;
    Stack<Integer> post;
    double tar;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        pre = new Stack<Integer>();
        post = new Stack<Integer>();
        tar = target;
        dfs0(root);
        dfs1(root);
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        while(i < k){
            if(pre.empty()){
                res.add(post.pop());
            }else if(post.empty()){
                res.add(pre.pop());
            }else if(target - pre.peek() < post.peek() - target){
                res.add(pre.pop());
            }else{
                res.add(post.pop());
            }
            i += 1;
        }
        return res;
    }
    private void dfs0(TreeNode root){
        if(root == null) return;
        dfs0(root.left);
        if(root.val >= tar) return;
        pre.push(root.val);
        dfs0(root.right);
    }
    private void dfs1(TreeNode root){
        if(root == null) return;
        dfs1(root.right);
        if(root.val < tar) return;
        post.push(root.val);
        dfs1(root.left);
    }
}
