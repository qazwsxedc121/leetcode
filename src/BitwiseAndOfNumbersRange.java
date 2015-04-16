/**
 * Created by Administrator on 2015/4/16.
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int a = m;
        int b = n;
        if(a == b) return a;
        int t = 30;
        return testBit(m,n,t);
    }
    private int testBit(int m, int n, int t) {
        int a = m & (1 << t);
        int b = n & (1 << t);
        if(a != b){
            return 0;
        }else{
            if( a == 0 ){
                return testBit(m,n, t - 1);
            }else {
                return (1 << t) | testBit(m,n,t-1);
            }
        }
    }

    public static void test() {
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(2,3));
    }
}
