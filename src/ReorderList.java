import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/12.
 */
public class ReorderList {
    public void reorderList(ListNode head){
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode p = head;
        while(p != null){
            list.add(p);
            p = p.next;
        }
        int n = list.size();
        int l = 0;
        int r = n - 1;
        while(l < r){
            ListNode temp = list.get(l).next;
            list.get(l).next = list.get(r);
            list.get(r).next = temp;
            l += 1;
            r -= 1;
        }
        if(l == r){
            list.get(l).next = null;
        }else{
            list.get(r).next = null;
        }
    }
}
