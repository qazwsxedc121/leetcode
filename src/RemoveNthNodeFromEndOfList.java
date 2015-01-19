/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 18:03
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        ListNode prehead = slow;
        slow.next = head;
        int i = 1;
        while(fast != null){
            i += 1;
            fast = fast.next;
            while(i > n+1){
                i -= 1;
                slow = slow.next;
            }
        }
        if(slow == prehead){
            return head.next;
        }else{
            slow.next = slow.next.next;
            return head;
        }
    }

/*    2 pass solution */
//    public ListNode removeNthFromEnd(ListNode head, int n){
//        int l = 1;
//        ListNode x = head.next;
//        while(x != null){
//            l += 1;
//            x = x.next;
//        }
//        head = removeNth(head, l - n);
//        return head;
//    }
//    public ListNode removeNth(ListNode head, int n){
//        if(n == 0){
//            return head.next;
//        }else if(n == 1){
//            head.next = head.next.next;
//        }else{
//            head.next = removeNth(head.next, n - 1);
//        }
//        return head;
//    }
    public static void test(){
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        System.out.println(l);
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(l, 2));
    }
}
