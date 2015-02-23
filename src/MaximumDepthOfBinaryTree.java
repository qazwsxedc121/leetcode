/**
 * User: guoxc
 * Date: 14-10-9
 * Time: 16:48
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
    public String toString(){
        String res = "" + val;
        if(left != null){
            res += "," + left.toString();
        }else{
            res += ",#";
        }
        if(right != null){
            res += "," + right.toString();
        }else{
            res += ",#";
        }
        return res;

    }
}

public class MaximumDepthOfBinaryTree {
    public int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else{
            return 1 + max(this.maxDepth(root.left), this.maxDepth(root.right));
        }
    };
    public static void test(){
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(t0) == 3);
    }
}
