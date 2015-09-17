import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/17.
 */
public class StrobogrammaticNumberIII {

// https://leetcode.com/discuss/55468/clear-java-ac-solution-using-strobogrammatic-number-method


    private List<String> getWithDigits(int x,int d){
        List<String> res = new ArrayList<String>();
        if(x == 0){
            res.add("");
            return res;
        }else if(x == 1){
            res.add("1"); res.add("8"); res.add("0");
            return res;
        }
        List<String> res0 = getWithDigits(x - 2, d);
        for(String s : res0){
            if(x != d){
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
    public int strobogrammaticInRange(String low, String high) {
        int n1 = low.length();
        int n2 = high.length();
        List<String> rst = new ArrayList<String>();
        for(int i = n1; i <= n2; i += 1){
            rst.addAll(getWithDigits(i,i));
        }
        int count = 0;
        for(String s : rst){
            int n = s.length();
            if((n == n1 && s.compareTo(low) < 0) || (n == n2 && s.compareTo(high) > 0)){
                continue;
            }
            count += 1;
        }
        return count;
    }
}