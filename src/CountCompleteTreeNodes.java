/**
 * Created by Administrator on 2015/6/6.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lvl = getLeftLevel(root);
        int l = 0;
        int r = (1 << (lvl - 1)) - 1;
        if(childByIndex(root, l, lvl) && childByIndex(root, r, lvl)){
            return (1 << lvl) - 1;
        }
        while(r - l > 1){
            int mid = (l + r) / 2;
            if(childByIndex(root, mid, lvl)){
                l = mid;
            }else{
                r = mid;
            }
        }
        return (1 << (lvl - 1)) + l;
    }
    private int getLeftLevel(TreeNode root){
        TreeNode p = root;
        int res = 0;
        while(p != null){
            p = p.left;
            res += 1;
        }
        return res;
    }
    private boolean childByIndex(TreeNode root, int index, int lvl){
        TreeNode p = root;
        int i = lvl - 2;
        while(i > - 1){
            if((index & (1 << i)) == 0){
                p = p.left;
            }else{
                p = p.right;
            }
            i -= 1;
        }
        return p != null;
    }
}