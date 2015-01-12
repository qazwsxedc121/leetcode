/**
 * User: guoxc
 * Date: 15-1-12
 * Time: 22:32
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
        if(k == 1) return head;
        ListNode c1 = head;
        ListNode c2 = head;
        ListNode res = head;
        int i = 0;
        while(c1 != null && i < k){
            res = c1;
            c1 = c1.next;
            i += 1;
        }
        if(i == k){
            ListNode t1 = head;
            ListNode t2 = head.next;
            ListNode t3 = null;
            t1.next = null;
            for(int j = 0; j < k-1; j += 1){
                t3 = t2.next;
                t2.next = t1;
                t1 = t2;
                t2 = t3;
            }
            c2.next = reverseKGroup(c1,k);
            return res;
        }else{
            return head;
        }
    }
    public static void test(){
        ListNode l = new ListNode(new int[]{1,2,3,4,5});
        ListNode l1 = new ListNode(new int[]{1});
        ListNode l2 = new ListNode(new int[]{1,2});
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(l2,2));
    }
}
