import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-7-13
 * Time: 21:53
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> color = new HashMap<TreeNode, Integer>();
        stack.add(root);
        ArrayList<TreeNode> pstack = null;
        ArrayList<TreeNode> qstack = null;
        while(stack.size() != 0){
            TreeNode top = stack.getLast();
            if(top == p){
                pstack = copyFrom(stack);
            }else if(top == q){
                qstack = copyFrom(stack);
            }
            if(pstack != null && qstack != null) break;
            if(!color.containsKey(top)){
                color.put(top, 1);
                if(top.left != null){
                    stack.add(top.left);
                }
            }else if(color.get(top) == 1){
                color.put(top, 2);
                if(top.right != null){
                    stack.add(top.right);
                }
            }else if(color.get(top) == 2){
                stack.removeLast();
            }
        }
        int i = 0;
        while(i < pstack.size() && i < qstack.size() && pstack.get(i) == qstack.get(i)){
            i += 1;
        }
        if(i == pstack.size()) return p;
        if(i == qstack.size()) return q;
        return pstack.get(i-1);
    }
    private ArrayList<TreeNode> copyFrom(List<TreeNode> l){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        for(TreeNode t : l){
            res.add(t);
        }
        return res;
    }

}