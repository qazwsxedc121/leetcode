/**
 * Created by Administrator on 2015/3/4.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int[] x){
        ListNode xnode = this;
        val = x[0];
        next = null;
        for(int i = 1; i < x.length; i += 1){
            xnode.next = new ListNode(x[i]);
            xnode = xnode.next;
        }
    }
    public String toString(){
        String x = ""+val;
        ListNode n = this.next;
        while(n != null){
            x = x + "->" + n.val;
            n = n.next;
        }
        return x;
    }
}
