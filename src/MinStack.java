/**
 * Created by Administrator on 2015/3/15.
 */
public class MinStack {
    private class MinStackNode{
        public int val;
        public MinStackNode nextBig;
        public MinStackNode pre;
        public MinStackNode next;
    }
    private MinStackNode head;
    private MinStackNode end;
    private MinStackNode minNode;
    public void push(int x) {
        if(head == null){
            head = new MinStackNode();
            head.val = x;
            end = head;
            minNode = head;
            return;
        }
        MinStackNode node = new MinStackNode();
        node.val = x;
        if(x < minNode.val){
            node.nextBig = minNode;
            minNode = node;
        }
        end.next = node;
        node.pre = end;
        end = node;
    }

    public void pop() {
        if(minNode == end){
            minNode = minNode.nextBig;
        }
        if(end != null && end.pre != null){
            MinStackNode p = end.pre;
            end.pre = null;
            p.next = null;
            end = p;
        }else if(end.pre == null){
            head = null;
            end = null;
            minNode = null;
        }

    }

    public int top() {
        return end.val;
    }

    public int getMin() {
        return minNode.val;
    }
}
