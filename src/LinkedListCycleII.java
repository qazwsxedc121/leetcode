/**
 * Created by Administrator on 2015/3/11.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow == fast){
            slow = head;
            fast = fast.next;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }else{
            return null;
        }
    }
}
