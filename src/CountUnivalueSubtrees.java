/**
 * Created by Administrator on 2015/9/3.
 */
public class CountUnivalueSubtrees {
    private boolean isUnival(TreeNode root){
        if(root == null) return true;
        else if(root.right == null && root.left == null) return true;
        else if(root.right == null){
            return root.left.val == root.val && isUnival(root.left);
        }else if(root.left == null){
            return root.right.val == root.val && isUnival(root.right);
        }else{
            return root.left.val == root.val && root.right.val == root.val && isUnival(root.left) && isUnival(root.right);
        }
    }
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(isUnival(root)){
            return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right) + 1;
        }else{
            return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        }
    }
}
