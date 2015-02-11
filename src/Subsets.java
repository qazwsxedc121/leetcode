import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/2/11.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S){
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] bits = new boolean[S.length];
        res.add(pickNumbers(S,bits));
        while(nextBits(bits)){
            res.add(pickNumbers(S,bits));
        }
        return res;
    }
    private boolean nextBits(boolean[] bits){
        boolean carry = true;
        for(int i = bits.length - 1; i > -1 ; i -= 1){
            if(bits[i] && carry){
                bits[i] = false;
                carry = true;
            }else if(carry){
                carry = false;
                bits[i] = true;
                break;
            }
        }
        return !carry;
    }
    private List<Integer> pickNumbers(int[] S, boolean[] bits){
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < S.length; i += 1){
            if(bits[i]) {
                res.add(S[i]);
            }
        }
        return res;
    }
    public static void test(){
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{3,4,1}));
    }
}
