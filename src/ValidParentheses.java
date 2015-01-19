import java.util.ArrayList;

/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 18:56
 */
public class ValidParentheses {
    public boolean isValid(String s){
        ArrayList<Character> stack = new ArrayList<Character>();
        char[] sarr = s.toCharArray();
        for(int i = 0; i < sarr.length; i += 1){
            if(stack.size() == 0){
                if(sarr[i] == '(' || sarr[i] == '[' || sarr[i] == '{'){
                    stack.add(sarr[i]);
                    continue;
                }else{
                    return false;
                }
            }
            char top = stack.get(stack.size() - 1);
            char now = sarr[i];
            if(top == '(' || top == '{' || top == '['){
                if(now == '(' || now == '{' || now == '['){
                    stack.add(now);
                }else if((now == '}' && top == '{') ||
                         (now == ')' && top == '(') ||
                         (now == ']' && top == '[')){
                    stack.remove(stack.size() - 1);
                }else{
                    return false;
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    public static void test(){
        System.out.println(new ValidParentheses().isValid("(([[]]))"));
    }
}
