/**
 * User: guoxc
 * Date: 15-7-10
 * Time: 22:54
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = null;
        if(fast.next == null){
            l2 = slow.next;
            slow.next = null;
            l1 = reverse(l1);
            l1 = l1.next;
        }else if(fast.next.next == null){
            l2 = slow.next;
            slow.next = null;
            l1 = reverse(l1);
        }

        return isSame(l1, l2);
    }
    private ListNode reverse(ListNode head){
        ListNode res = null;
        ListNode n1 = head;
        ListNode n2 = head.next;
        if(n2 == null){
            return n1;
        }
        ListNode n3 = head.next.next;
        n1.next = null;
        while(n3 != null && n3.next != null){
            n2.next = n1;
            n1 = n2;
            n2 = n3;
            n3 = n3.next;
        };
        n2.next = n1;
        if(n3 != null){
            n3.next = n2;
            n2 = n3;
        }
        return n2;
    }
    private boolean isSame(ListNode l1, ListNode l2){
        while(l1 != null && l1.val == l2.val){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null;
    }
    public static void test(){
        new PalindromeLinkedList().isPalindrome(new ListNode(new int[]{1,2,3,2,1}));
    }
}
