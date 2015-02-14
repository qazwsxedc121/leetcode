/**
 * User: guoxc
 * Date: 15-2-14
 * Time: 10:37
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode res = new ListNode(head.val);
        ListNode p = head;
        ListNode p2 = res;
        int old_val = head.val;
        while(p != null){
            while(p != null && p.val == old_val){
                p = p.next;
            }
            if(p == null){
                p2.next = null;
                break;
            }
            p2.next = new ListNode(p.val);
            old_val = p.val;
            p2 = p2.next;
        }
        return res;
    }
    public static void test(){
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        ListNode l = new ListNode(new int[]{1,1,2,3,3});
        System.out.println(r.deleteDuplicates(l));
    }
}
