import java.util.Stack;

/**
 * User: guoxc
 * Date: 15-7-7
 * Time: 23:25
 */



public class ImplementQueueSsingStacks {
    private class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        private Stack<Integer> inputStack;
        private Stack<Integer> outputStack;
        // Push element x to the back of queue.
        public void push(int x) {
            inputStack.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            if(outputStack.empty()){
                flip();
            }
            outputStack.pop();
        }

        // Get the front element.
        public int peek() {
            if(outputStack.empty()){
                flip();
            }
            return outputStack.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return inputStack.empty() && outputStack.empty();
        }

        private void flip(){
            while(!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }

        public MyQueue(){
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
            inputStack = stack1;
            outputStack = stack2;
        }
    }
}
