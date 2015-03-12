/**
 * Created by Administrator on 2015/3/13.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode p = head;
        if(p == null || p.next == null) return head;
        ListNode res = head;
        ListNode end = p;
        p = p.next;
        ListNode next = p.next;
        if(p.val < res.val){
            p.next = res;
            end.next = next;
            res = p;
        }else{
            end = end.next;
        }
        p = next;
        while(p != null){
            next = p.next;
            if(p.val < res.val){
                p.next = res;
                end.next = next;
                res = p;
                p = next;
                continue;
            }else if(p.val >= end.val){
                end = end.next;
                p = next;
                continue;
            }
            ListNode p2 = res;
            while (p2.next != end && p2.next.val < p.val){
                p2 = p2.next;
            }
            ListNode temp = p2.next;
            p2.next = p;
            p.next = temp;
            p = next;
            end.next = next;
        }
        return res;
    }
    public static void test(){
        InsertionSortList i = new InsertionSortList();
        System.out.println(i.insertionSortList(new ListNode(new int[]{4,2,1,3})));
    }
}
