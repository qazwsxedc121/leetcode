import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> level = new ArrayList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        level.add(root);
        while(!level.isEmpty()){
            res.add(level.get(level.size() - 1).val);
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode t: level){
                if(t.left != null){
                    nextLevel.add(t.left);
                }
                if(t.right != null){
                    nextLevel.add(t.right);
                }
            }
            level = nextLevel;
        }
        return res;
    }
}
