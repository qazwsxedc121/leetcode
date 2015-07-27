import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-7-27
 * Time: 23:17
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> getList(List<Character> ops, List<Integer> nums){
        int n = ops.size();
        List<Integer> res = new ArrayList<Integer>();
        if(n == 0){
            res.add(nums.get(0));
            return res;
        }
        if(n == 1){
            res.add(doCalc(nums.get(0),nums.get(1),ops.get(0)));
            return res;
        }else{
            for(int i = 0; i < n; i += 1){
                char op = ops.get(i);
                List<Integer> li1 = subIntList(nums, 0, i+1);
                List<Integer> li2 = subIntList(nums, i+1, n+1);
                List<Character> lc1 = subCharList(ops, 0, i);
                List<Character> lc2 = subCharList(ops, i+1, n);
                List<Integer> l1 = getList(lc1, li1);
                List<Integer> l2 = getList(lc2, li2);
                for(Integer it1 : l1){
                    for(Integer it2 : l2){
                        res.add(doCalc(it1, it2, op));
                    }
                }
            }
            return res;
        }
    }
    public List<Integer> subIntList(List<Integer> l, int start, int end){
        List<Integer> res = new ArrayList<Integer>();
        for(int i = start; i < end; i += 1){
            res.add(l.get(i));
        }
        return res;
    }
    public List<Character> subCharList(List<Character>l, int start, int end){
        List<Character> res = new ArrayList<Character>();
        for(int i = start; i < end; i += 1){
            res.add(l.get(i));
        }
        return res;
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums0 = new ArrayList<Integer>();
        List<Character> ops0 = new ArrayList<Character>();
        int i = 0;
        int now = 0;
        while(i < input.length()){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                ops0.add(input.charAt(i));
                nums0.add(now);
                now = 0;
            }else{
                int c = input.charAt(i) - '0';
                now = now*10 + c;
            }
            i += 1;
        }
        nums0.add(now);
        return getList(ops0, nums0);

    }
    public int doCalc(int a, int b, char op){
        switch(op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return 0;
        }
    }

}
