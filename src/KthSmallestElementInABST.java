/**
 * Created by Administrator on 2015/7/2.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if(root.left == null && root.right == null){
            return root.val;
        }else if(root.left == null){
            if(k == 1){
                return root.val;
            }else{
                return kthSmallest(root.right, k - 1);
            }
        }else if(root.right == null){
            if(k == getNum(root.left) + 1){
                return root.val;
            }else{
                return kthSmallest(root.left, k);
            }
        }
        int l = getNum(root.left);
        if(k == l + 1){
            return root.val;
        }else if(k < l + 1){
            return kthSmallest(root.left, k);
        }else{
            return kthSmallest(root.right, k - l - 1);
        }
    }
    public int getNum(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null){
            return 1 + getNum(root.right);
        }else if(root.right == null){
            return 1 + getNum(root.left);
        }else{
            return 1 + getNum(root.left) + getNum(root.right);
        }
    }
}
