/**
 * Created by Administrator on 2015/3/11.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        if(p == null || p.next == null) return false;
        if(p.next == head) return true;
        ListNode t = p.next;
        p.next = null;
        p = t;
        while (p != null && p != head) {
            ListNode temp = p.next;
            p.next = head;
            p = temp;

        }
        return p != null;
    }
    public static void test(){
        ListNode t0 = new ListNode(1);
        ListNode t1 = new ListNode(2);
        t0.next = t1;
        t1.next = t0;
        LinkedListCycle l = new LinkedListCycle();
        System.out.println(l.hasCycle(t0));

    }
}
