import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2015/3/17.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator){
        boolean negative = (long)numerator * (long)denominator < 0;
        long numer = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        long lpart = numer / denom;
        long t = numer % denom;
        if(t == 0){
            return negative ? "-" + lpart :"" + lpart;
        }
        Set<Long> set = new HashSet<Long>();
        List<Long> list = new LinkedList<Long>();
        String rpart = "";
        while(t > 0 && rpart.length() < 1000){
            if(set.contains(t)){
                break;
            }else {
                set.add(t);
                list.add(t);
            }
            t = t * 10;
            rpart += "" + (t / denom);
            t = t % denom;
        }
        String res = negative ? "-" : "";
        if(t == 0 || rpart.length() == 1000){
            return res + lpart + "." + rpart;
        }else if(t< 0){
            return res + ((0.0 + numerator) / denominator);
        }else{
            int from = 0;
            for(int i = 0; i < list.size(); i += 1){
                if(list.get(i) == t){
                    from = i;
                    break;
                }
            }
            return res + lpart + "."+ rpart.substring(0,from) + "(" + rpart.substring(from) + ")";
        }
    }
    public static void test(){
        FractionToRecurringDecimal f = new FractionToRecurringDecimal();
        System.out.println(f.fractionToDecimal(-2147483648, 1));
    }
}
