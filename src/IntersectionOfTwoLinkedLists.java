/**
 * Created by Administrator on 2015/3/16.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB){
            return headA;
        }else if(headA != null && headA.next == headB){
            return headB;
        }else if(headB != null && headB.next == headA){
            return headA;
        }else if(headA == null || headB == null){
            return null;
        }
        int a_len = getLength(headA);
        int b_len = getLength(headB);
        if(a_len > b_len){
            while(a_len > b_len){
                headA = headA.next;
                a_len -= 1;
            }
        }else if(a_len < b_len){
            while(a_len < b_len){
                headB = headB.next;
                b_len -= 1;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int getLength(ListNode a){
        int i = 0;
        while(a != null){
            i += 1;
            a = a.next;
        }
        return i;
    }
}
