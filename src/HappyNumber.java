import java.util.HashSet;

/**
 * Created by Administrator on 2015/4/23.
 */
public class HappyNumber {
    public boolean isHappy(int n){
        HashSet<Integer> x = new HashSet<Integer>();
        while (n != 1 && !x.contains(n)){
            x.add(n);
            n = transform(n);
        }
        return n == 1;
    }
    private int transform(int k){
        int res = 0;
        while (k != 0){
            int t = k % 10;
            k = k / 10;
            res += t * t;
        }
        return res;
    }

    public static void test() {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(2));
        System.out.println(h.isHappy(3));
    }
}
