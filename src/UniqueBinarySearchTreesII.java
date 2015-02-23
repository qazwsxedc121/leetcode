import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-23
 * Time: 22:49
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            List<TreeNode> res = new ArrayList<TreeNode>();
            res.add(null);
            return res;
        }
        return generateBetween(1, n + 1);
    }
    private List<TreeNode> generateBetween(int l, int r){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(l == r) return res;
        if(r - l == 1){
            res.add(new TreeNode(l));
            return res;
        }
        for(int i = l; i < r; i += 1){
            List<TreeNode> lt = generateBetween(l,i);
            List<TreeNode> rt = generateBetween(i + 1, r);
            int l_len = lt.size();
            int r_len = rt.size();
            if(l_len == 0){
                for(int j = 0; j < r_len; j += 1){
                    TreeNode node = new TreeNode(i);
                    node.right = rt.get(j);
                    res.add(node);
                }
            }else if(r_len == 0){
                for(int j = 0; j < l_len; j += 1){
                    TreeNode node = new TreeNode(i);
                    node.left = lt.get(j);
                    res.add(node);
                }
            }else{
                for(int j = 0; j < r_len; j += 1){

                    for(int k = 0; k < l_len; k += 1){
                        TreeNode node = new TreeNode(i);
                        node.left = lt.get(k);
                        node.right = rt.get(j);
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
    private void tReplace(TreeNode root, int m){
        if(root == null) return;
        root.val += m;
        if(root.left != null){
            tReplace(root.left,m);
        }
        if(root.right != null){
            tReplace(root.right,m);
        }
    }
    public static void test(){
        UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
        System.out.println(u.generateTrees(5));
    }
}
