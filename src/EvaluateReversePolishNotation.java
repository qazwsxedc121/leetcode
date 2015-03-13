import java.util.Stack;

/**
 * Created by Administrator on 2015/3/13.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i += 1){
            String t = tokens[i];
            if(isOpt(t)){
                int a = stack.pop();
                int b = stack.pop();
                if(t.equals("+")){
                    stack.push(b + a);
                }else if(t.equals("-")){
                    stack.push(b - a);
                }else if(t.equals("*")){
                    stack.push(b * a);
                }else {
                    stack.push(b / a);
                }
            }else{
                int c = Integer.parseInt(t);
                stack.push(c);
            }
        }
        return stack.pop();
    }
    private boolean isOpt(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
