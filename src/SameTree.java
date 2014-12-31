/**
 * User: guoxc
 * Date: 14-10-9
 * Time: 17:02
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
        }
    }

    public static void test(){
        TreeNode t0 = new TreeNode(0);
        TreeNode t0z = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t0z.left = t1;
        t0z.right = t2;
        System.out.println(new SameTree().isSameTree(t0,t0z));
    }
}
