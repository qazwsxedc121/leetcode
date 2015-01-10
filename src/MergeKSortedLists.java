import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 22:20
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists.size() == 0){
            return null;
        }else if(lists.size() == 1){
            return lists.get(0);
        }else{
            return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)), mergeKLists(lists.subList(lists.size()/2, lists.size())));
        }
    }
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
        ListNode l1 = new ListNode(new int[]{1,3,4,6,8,10});
        ListNode l2 = null;
        ListNode l3 = new ListNode(new int[]{4,5,7,11});
        ListNode l4 = new ListNode(1);
        List<ListNode> l = new ArrayList<ListNode>();
        l.add(l1); l.add(l2); l.add(l3); l.add(l4);
        System.out.println(new MergeKSortedLists().mergeKLists(l));
    }
}
