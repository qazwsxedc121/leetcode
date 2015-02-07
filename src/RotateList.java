/**
 * Created by Administrator on 2015/2/7.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n){
        int len = 0;
        ListNode p = head;
        while(p != null){
            len += 1;
            p = p.next;
        }
        if(len == 0) return head;
        int k = n % len;
        if(k == 0) return head;
        p = head;
        for(int i = 1; i < len - k; i += 1){
            p = p.next;
        }
        ListNode res = p.next;
        p.next = null;
        p = res;
        for(int i = 1; i < k; i += 1){
            p = p.next;
        }
        p.next = head;
        return res;
    }
    public static void test(){
        RotateList instance = new RotateList();
        ListNode l = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(instance.rotateRight(l,2));
    }
}
