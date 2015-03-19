import java.util.Stack;

/**
 * Created by Administrator on 2015/3/19.
 */
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        addLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int res = 0;
        if(!stack.isEmpty()){
            TreeNode n = stack.pop();
            res = n.val;
            if(n.right != null){
                addLeft(n.right);
            }
        }
        return res;
    }

    private void addLeft(TreeNode root){
        TreeNode p = root;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
    }
    public static void test(){
        TreeNode n0 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        n0.left = n1;
        n0.right = n2;
        BinarySearchTreeIterator n = new BinarySearchTreeIterator(n0);
        while(n.hasNext()){
            System.out.println(n.next());
        }
    }
}
