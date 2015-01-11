/**
 * User: guoxc
 * Date: 15-1-11
 * Time: 22:23
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head){
        ListNode res = head;
        ListNode current = head;
        ListNode old_c = head;
        if(current != null && current.next != null){
            ListNode c1 = current;
            ListNode c2 = current.next;
            ListNode c3 = current.next.next;

            res = c2;
            c2.next = c1;
            c1.next = c3;
            current = c3;
            old_c = c1;
        }
        while(current != null && current.next != null){
            ListNode c1 = current;
            ListNode c2 = current.next;
            ListNode c3 = current.next.next;

            old_c.next = c2;
            c2.next = c1;
            c1.next = c3;
            current = c3;
            old_c = c1;
        }
        return res;

    }
    public static void test(){
        ListNode l1 = new ListNode(new int[]{1,2,3,4});
        System.out.println(new SwapNodesInPairs().swapPairs(l1));
    }
}
