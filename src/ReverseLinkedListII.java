/**
 * User: guoxc
 * Date: 15-2-19
 * Time: 21:53
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = res;
        for(int i = 1; i < m; i += 1){
            p = p.next;
        }
        ListNode p2 = p.next;
        ListNode p3 = p.next;
        ListNode past = null;
        ListNode next = p2.next;
        for(int i = 0; i < n - m + 1; i += 1){


            next = p2.next;
            p2.next = past;
            past = p2;
            p2 = next;
        }

        p.next = past;
        p3.next = next;
        return res.next;

    }
    public static void test(){
        ListNode l = new ListNode(new int[]{1,2,3,4,5});
        ReverseLinkedListII r = new ReverseLinkedListII();
        System.out.println(r.reverseBetween(l,2,4));
    }
}
