/**
 * Created by Administrator on 2015/5/5.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p0 = head;
        ListNode p1 = head.next;
        ListNode next = p1.next;
        p0.next = null;
        while(next != null){
            p1.next = p0;
            p0 = p1;
            p1 = next;
            next = p1.next;
        }
        p1.next = p0;
        return p1;
    }
}
