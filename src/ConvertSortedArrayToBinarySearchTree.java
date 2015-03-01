/**
 * Created by Administrator on 2015/3/1.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num){
        return constructBST(num,0, num.length);
    }
    private TreeNode constructBST(int[] num, int l, int r){
        if(l == r){
            return null;
        }else if(r - l == 1){
            return new TreeNode(num[l]);
        }else{
            int mid = (l + r) / 2;
            TreeNode res = new TreeNode(num[mid]);
            res.left = constructBST(num, l, mid);
            res.right = constructBST(num, mid + 1, r);
            return res;
        }
    }
    public static void test(){
        ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
        System.out.println(c.sortedArrayToBST(new int[]{1,2,3,4,5}));
    }
}
