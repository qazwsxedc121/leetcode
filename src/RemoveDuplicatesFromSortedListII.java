/**
 * User: guoxc
 * Date: 15-2-14
 * Time: 12:39
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null) return null;
        ListNode res = new ListNode(0);
        ListNode p = head;
        ListNode p2 = res;
        if(p.next != null && p.val != p.next.val){
            p2.next = new ListNode(p.val);
            p2 = p2.next;
        }else if(p.next == null){
            p2.next = new ListNode(p.val);
            p2 = p2.next;
        }
        int old_v = p.val;
        while(p != null){
            if(p.val != old_v){
                if(p.next != null){
                    if(p.next.val != p.val){
                        p2.next = new ListNode(p.val);

                        p2 = p2.next;
                    }
                }else{
                    p2.next = new ListNode(p.val);
                    break;
                }
            }
            old_v = p.val;
            p = p.next;
        }
        return res.next;
    }
    public static void test(){
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        System.out.println(r.deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5})));
        System.out.println(r.deleteDuplicates(new ListNode(new int[]{1,1,1,2,2,3,3})));
    }
}
