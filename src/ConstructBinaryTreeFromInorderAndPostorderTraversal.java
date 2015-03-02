import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-3-2
 * Time: 15:52
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }else if(inorder.length == 1){
            return new TreeNode(inorder[0]);
        }
        int root = postorder[postorder.length - 1];
        int rindex = 0;
        for(int i = 0; i < inorder.length; i += 1){
            if(inorder[i] == root){
                rindex = i;
                break;
            }
        }
        TreeNode res = new TreeNode(root);
        if(rindex > 0){
            int[] in = Arrays.copyOfRange(inorder, 0, rindex);
            int[] post = Arrays.copyOfRange(postorder, 0, rindex);
            res.left = buildTree(in, post);
        }
        if(rindex < inorder.length - 1){
            int[] in = Arrays.copyOfRange(inorder, rindex + 1, inorder.length);
            int[] post = Arrays.copyOfRange(postorder, rindex, postorder.length - 1);
            res.right = buildTree(in, post);
        }
        return res;
    }
    public static void test(){
        ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        System.out.println(c.buildTree(new int[]{1,2,3,4,5,6,7}, new int[]{1,3,2,5,7,6,4}));
    }
}
