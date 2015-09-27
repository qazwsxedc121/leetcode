import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/58614/java-standard-backtrace-ac-solutoin-short-and-clear
 */
public class ExpressionAddOperators {
    public void helper(List<String> res, String num, int pos, String path, long eval, int target, long multed){

        if(pos == num.length()){
            if(eval == target){
                res.add(path);
            }
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(res, num, i + 1, "" + cur, cur, target ,cur); // start
            }else{
                helper(res, num, i + 1, path + "+" + cur, eval + cur, target, cur);
                helper(res, num, i + 1, path + "-" + cur, eval - cur, target, -cur);
                helper(res, num, i + 1, path + "*" + cur, eval - multed + cur * multed, target, cur * multed);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(res, num, 0, "", 0, target, 1);
        return res;
    }
}
