import java.util.ArrayList;

/**
 * User: guoxc
 * Date: 14-10-9
 * Time: 17:13
 */
public class ReverseInteger {
    public int reverse(int x) {
        ArrayList<Integer> k = new ArrayList<Integer>();
        int v = x;
        int r = 0;
        while(v != 0){
            k.add(v % 10);
            v = v / 10;
        };
        int j = 1;
        for(int i = k.size()-1; i >= 0; i -= 1){
            r += k.get(i) * j;
            j *= 10;
        }
        return r;
    }
    public static void test(){
        ReverseInteger ri = new ReverseInteger();
        Test.pt(ri.reverse(123) == 321);
        Test.pt(ri.reverse(-321) == -123);
        Test.pt(ri.reverse(1) == 1);
    }
}
