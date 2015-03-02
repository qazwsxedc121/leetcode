import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-3-2
 * Time: 15:35
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }else if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        int r = preorder[0];
        int rindex = 0;
        for(int i = 0; i < inorder.length; i += 1){
            if(r == inorder[i]){
                rindex = i;
            }
        }
        TreeNode res = new TreeNode(r);
        if(rindex > 0){
            int[] pre = Arrays.copyOfRange(preorder, 1, rindex + 1);
            int[] in = Arrays.copyOfRange(inorder, 0, rindex);
            res.left = buildTree(pre, in);
        }
        if(rindex < inorder.length - 1){
            int[] pre = Arrays.copyOfRange(preorder, rindex + 1, preorder.length);
            int[] in = Arrays.copyOfRange(inorder, rindex + 1, inorder.length);
            res.right = buildTree(pre, in);
        }
        return res;

    }
    public static void test(){
        ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(c.buildTree(new int[]{4,2,1,3,6,5,7}, new int[]{1,2,3,4,5,6,7}));
    }
}
