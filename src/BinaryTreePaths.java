import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-8-19
 * Time: 21:46
 */
public class BinaryTreePaths {

    public String add(String l, String r){
        return l + "->" + r;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        if(root.left == null && root.right == null){
            res.add("" + root.val);
            return res;
        }else{
            List<String> l = binaryTreePaths(root.left);
            for(int i = 0; i < l.size() ; i += 1){
                res.add(add(""+root.val,l.get(i)));
            }
            List<String> r = binaryTreePaths(root.right);
            for(int i = 0; i < r.size() ; i += 1){
                res.add(add(""+root.val,r.get(i)));
            }
            return res;
        }
    }
}
