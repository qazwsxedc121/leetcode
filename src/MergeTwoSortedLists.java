/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 19:13
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pt1 = l1;
        ListNode pt2 = l2;
        ListNode head = null;
        if (pt1 == null && pt2 == null) {
            return null;
        } else if (pt1 == null) {
            head = new ListNode(pt2.val);
            pt2 = pt2.next;
            copyLinkList(pt2, head);
            return head;
        } else if (pt2 == null) {
            head = new ListNode(pt1.val);
            pt1 = pt1.next;
            copyLinkList(pt1, head);
            return head;
        }
        if (pt1.val < pt2.val) {
            head = new ListNode(pt1.val);
            pt1 = pt1.next;
        } else {
            head = new ListNode(pt2.val);
            pt2 = pt2.next;
        }
        ListNode x = head;
        while (pt1 != null && pt2 != null) {
            if (pt1.val < pt2.val) {
                x.next = new ListNode(pt1.val);
                x = x.next;
                pt1 = pt1.next;
            } else {
                x.next = new ListNode(pt2.val);
                x = x.next;
                pt2 = pt2.next;
            }
        }
        copyLinkList(pt1, x);
        copyLinkList(pt2, x);
        return head;
    }
    public void copyLinkList(ListNode pt, ListNode x){
        while(pt != null){
            x.next = new ListNode(pt.val);
            x = x.next;
            pt = pt.next;
        }
    }
    public static void test(){
        ListNode l1 = new ListNode(new int[]{1,2,4,6,10});
        ListNode l2 = new ListNode(new int[]{3,4,5,6,7});
        System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1,l2));
    }
}
