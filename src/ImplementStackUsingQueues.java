import java.util.LinkedList;
import java.util.Queue;

/**
 * User: guoxc
 * Date: 15-6-11
 * Time: 17:05
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> queue0;
    private Queue<Integer> queue1;
    private Queue<Integer> in;
    private Queue<Integer> out;

    public ImplementStackUsingQueues(){
        queue0 = new LinkedList<Integer>();
        queue1 = new LinkedList<Integer>();
        in = queue0;
        out = queue1;
    }

    private void swapInOut(){
        Queue<Integer> temp = in;
        in = out;
        out = temp;
    }

    // Push element x onto stack.
    public void push(int x) {
        in.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(in.size() > 1){
            out.offer(in.poll());
        }
        in.poll();
        swapInOut();
    }



    // Get the top element.
    public int top() {
        while(in.size() > 1){
            out.offer(in.poll());
        }
        int res = in.poll();
        out.offer(res);
        swapInOut();
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
