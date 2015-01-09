import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 19:52
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n){
        return genSub(n,n,0);
    }
    private List<String> genSub(int l, int r, int xlvl){
        List<String> res = new ArrayList<String>();
        if(l == 0){
            String s = "";
            for(int i = 0; i < r; i += 1){
                s += ")";
            }
            res.add(s);
            return res;
        }else if(r == 0){
            String s = "";
            for(int i = 0; i < r; i += 1){
                s += "(";
            }
            res.add(s);
            return res;
        }else{
            List<String> l1 = genSub(l-1,r,xlvl+1);
            for(int i = 0; i < l1.size(); i += 1){
                res.add("(" + l1.get(i));
            }
            if(xlvl > 0){
                List<String> r1 = genSub(l, r-1, xlvl-1);
                for(int i = 0; i < r1.size(); i += 1){
                    res.add(")" + r1.get(i));
                }
            }
        }
        return res;
    }
    public static void test(){
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
