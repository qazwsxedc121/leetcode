/**
 * Created by Administrator on 2015/4/24.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val){
        ListNode res = null;
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null) return res;
        res = head;
        ListNode p = head;
        ListNode q = head;
        while(q != null){
            q = q.next;
            while (q != null && q.val == val){
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return res;
    }
}
