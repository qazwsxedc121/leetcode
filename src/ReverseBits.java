/**
 * User: guoxc
 * Date: 15-3-23
 * Time: 10:21
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int t = 0;
        int res = 0;
        for(int i = 0; i < 31; i += 1){
            t = n & 1;
            res |= t;
            res = res << 1;
            n = n >>> 1;
        }
        res |= n;
        return res;
    }
    public static void test(){
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(1));
        System.out.println(r.reverseBits(-2147483648));
    }
}
