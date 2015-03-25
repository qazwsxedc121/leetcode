/**
 * User: guoxc
 * Date: 15-3-24
 * Time: 10:45
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        int k = 0;
        for(int i = 0; i < 32; i += 1){
            k = n & 1;
            res += k;
            n = n >>> 1;
        }
        return res;
    }
}
