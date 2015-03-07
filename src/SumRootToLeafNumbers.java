/**
 * Created by Administrator on 2015/3/7.
 */
public class SumRootToLeafNumbers {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root,0);
        return res;
    }
    private void traverse(TreeNode root, int v){
        if(root == null) return;
        if(root.left == null && root.right == null){
            res += root.val + (v * 10);
        }else if(root.left == null){
            traverse(root.right, (v * 10) + root.val);
        }else if(root.right == null){
            traverse(root.left, (v * 10) + root.val);
        }else{
            traverse(root.left, (v * 10) + root.val);
            traverse(root.right, (v * 10) + root.val);
        }

    }
    public static void test(){
        TreeNode t0 = new TreeNode(8);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(5);
        t0.left = t1;
        t0.right = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        SumRootToLeafNumbers s=  new SumRootToLeafNumbers();
        System.out.println(s.sumNumbers(t0));
    }
}
