/**
 * User: guoxc
 * Date: 15-3-13
 * Time: 14:52
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2head = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(l2head);
        return mergeList(l1,l2);
    }
    private ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode l1p = l1;
        ListNode l2p = l2;
        ListNode res = null;
        ListNode resEnd = null;
        if(l1p.val > l2p.val){
            res = l2p;
            resEnd = l2p;
            l2p = l2p.next;

        }else{
            res = l1p;
            resEnd = l1p;
            l1p = l1p.next;
        }
        while(l1p != null && l2p != null){
            if(l1p.val > l2p.val){
                resEnd.next = l2p;
                resEnd = l2p;
                l2p = l2p.next;
            }else{
                resEnd.next = l1p;
                resEnd = l1p;
                l1p = l1p.next;
            }
        }
        if(l1p != null){
            resEnd.next = l1p;
        }else{
            resEnd.next = l2p;
        }
        return res;
    }
    public static void test(){
        SortList s = new SortList();
        System.out.println(s.sortList(new ListNode(new int[]{3,4,6,2,7,5,1})));
    }
}
