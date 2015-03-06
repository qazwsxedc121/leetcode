import java.util.HashMap;

/**
 * Created by Administrator on 2015/3/6.
 */
public class BinaryTreeMaximumPathSum {
    private HashMap<TreeNode, Integer> hmax = new HashMap<TreeNode, Integer>();
    private HashMap<TreeNode, Integer> xmax = new HashMap<TreeNode, Integer>();
    public int maxPathSum(TreeNode root){
        if(xmax.containsKey(root)) return xmax.get(root);
        int rl = root.val;
        int l = maxSumToBottom(root.left);
        int r = maxSumToBottom(root.right);
        if(l > 0) rl += l;
        if(r > 0) rl += r;
        if(root.left != null){
            int lp = maxPathSum(root.left);
            if(lp > rl) rl = lp;
        }
        if(root.right != null){
            int rp = maxPathSum(root.right);
            if(rp > rl) rl = rp;
        }
        xmax.put(root, rl);
        return rl;
    }
    private int maxSumToBottom(TreeNode root){
        if(hmax.containsKey(root)) return hmax.get(root);
        if(root == null) return 0;
        int l = maxSumToBottom(root.left) + root.val;
        int r = maxSumToBottom(root.right) + root.val;
        int v = max(new int[]{l,r,root.val});
        hmax.put(root, v);
        return v;
    }
    private int max(int[] r){
        int m = r[0];
        for(int i = 1; i < r.length; i += 1){
            if(r[i] > m){
                m = r[i];
            }
        }
        return m;
    }
}
