/**
 * User: guoxc
 * Date: 15-2-16
 * Time: 14:51
 */
public class PartitionList {
    public ListNode partitition(ListNode head, int x){
        ListNode res = null;
        ListNode p1 = res;
        ListNode p2 = null;
        ListNode p2h = null;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                if(p1 == null){
                    res = new ListNode(p.val);
                    p1 = res;
                }else {
                    p1.next = new ListNode(p.val);
                    p1 = p1.next;
                }
            }else{
                if(p2 == null){
                    p2h = new ListNode(p.val);
                    p2 = p2h;
                }else {
                    p2.next = new ListNode(p.val);
                    p2 = p2.next;
                }
            }
            p = p.next;
        }
        if(p1 != null) {
            p1.next = p2h;
        }else{
            res = p2h;
        }
        return res;
    }
    public static void test(){
        PartitionList p = new PartitionList();
        ListNode o = new ListNode(new int[]{1,4,3,2,5,2});
        System.out.println(p.partitition(o,3));
    }
}
