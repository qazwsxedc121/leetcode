import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<Integer>();

        int j = 0;
        int j2 = 1;
        res.add(0);
        while(j < n){
            for(int i = res.size() - 1; i > -1; i -= 1){
                res.add(j2 + res.get(i));
            }
            j += 1;
            j2 = 2 * j2;
        }


        return res;
    }
    public static void test(){
        GrayCode g = new GrayCode();
        System.out.println(g.grayCode(5));
    }
}
