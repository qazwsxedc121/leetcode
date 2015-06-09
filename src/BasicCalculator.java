import java.util.Stack;

/**
 * User: guoxc
 * Date: 15-6-9
 * Time: 20:40
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
        op.push('+');
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i += 1){
            char c = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }
        }
        s = sb.toString();
        s = "(" + s + ")";
        int res = 0;
        for(int i = 0; i < s.length(); i += 1){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                int num = c - '0';
                int j = i + 1;
                c = s.charAt(j);
                while(c <= '9' && c >= '0'){
                    num = (num * 10) + c - '0';
                    i += 1;
                    j += 1;
                    c = s.charAt(j);
                }
                if(op.peek() == '+'){
                    int c0 = stack.pop();
                    stack.push(num + c0);
                }else if(op.peek() == '-'){
                    int c0 = stack.pop();
                    stack.push(c0 - num);
                }
                op.pop();

            }else if(c == '('){
                stack.push(0);
                op.push('+');
            }else if(c == ')'){
                int k = stack.pop();
                if(stack.isEmpty()) return k;
                int k0 = stack.pop();
                if(op.peek() == '+'){
                    stack.push(k0 + k);
                }else{
                    stack.push(k0 - k);
                }
                op.pop();
            }else if(c == '+'){
                op.push('+');
            }else if(c == '-'){
                op.push('-');
            }

        }
        return res;
    }
}