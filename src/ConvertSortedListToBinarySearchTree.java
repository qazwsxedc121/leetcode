/**
 * Created by Administrator on 2015/3/1.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head){
        int c = 0;
        ListNode r = head;
        while(r != null){
            r = r.next;
            c += 1;
        }
        return constructBST(head, c);
    }
    private TreeNode constructBST(ListNode head, int to){
        if(head == null || to == -1){
            return null;
        }
        ListNode r= head;
        int mid = to / 2;
        for(int i = mid; i > 0; i -= 1){
            r = r.next;
        }

        TreeNode res = new TreeNode(r.val);
        res.left = constructBST(head, mid - 1);
        res.right = constructBST(r.next, to - mid - 1);
        return res;
    }
    public static void test(){
        ConvertSortedListToBinarySearchTree c = new ConvertSortedListToBinarySearchTree();
        System.out.println(c.sortedListToBST(new ListNode(new int[]{1,2,3,4,5,6,7})));
    }
}
