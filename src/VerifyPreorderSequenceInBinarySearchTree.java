/**
 * Created by Administrator on 2015/9/6.
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    private boolean isPreorder(int[] nums, int start, int end){
        if(end - start < 2) return true;
        int root = nums[start];
        int l = start + 1;
        int r = end;
        while(l <= r && nums[l] < root) l += 1;
        int mid = l;
        while(l <= r && nums[l] > root) l += 1;
        if(l != r + 1){
            return false;
        }
        return isPreorder(nums, start+1, mid - 1) && isPreorder(nums, mid, r);

    }
    public boolean verifyPreorder(int[] preorder) {
        return isPreorder(preorder, 0, preorder.length - 1);
    }
}
