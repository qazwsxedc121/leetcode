import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-3-3
 * Time: 14:56
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)return res;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                List<Integer> l = new LinkedList<Integer>();
                l.add(sum);
                res.add(l);
            }
            return res;
        }else if(root.left == null){
            List<List<Integer>> l = pathSum(root.right, sum - root.val);
            for(int i = 0; i < l.size(); i += 1){
                l.get(i).add(0, root.val);
            }
            return l;
        }else if(root.right == null){
            List<List<Integer>> l = pathSum(root.left, sum - root.val);
            for(int i = 0; i < l.size(); i += 1){
                l.get(i).add(0, root.val);
            }
            return l;
        }else{
            List<List<Integer>> l = pathSum(root.left, sum - root.val);
            for(int i = 0; i < l.size(); i += 1){
                l.get(i).add(0, root.val);
                res.add(l.get(i));
            }
            List<List<Integer>> r = pathSum(root.right, sum - root.val);
            for(int i = 0; i < r.size(); i += 1){
                r.get(i).add(0, root.val);
                res.add(r.get(i));
            }
            return res;
        }
    }
}
