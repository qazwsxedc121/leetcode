/**
 * User: guoxc
 * Date: 15-7-8
 * Time: 22:21
 */
public class NumberOfDigitOne {
    private long[] counts;
    public int countDigitOne(int n) {

        counts = new long[12];
        counts[0] = 0; // < 1
        long c = 1;
        for(int i = 1; i < 12; i += 1){
            counts[i] = 10 * counts[i-1] + c;
            c *= 10;
        }
        return (int)countIter(n);
    }
    private long countIter(long n){
        if(n <= 0){
            return 0;
        }else if(n < 10){
            return 1;
        }
        long k = 1;
        int d = 0;
        long nn = n + 1;
        while(k < nn){
            k *= 10;
            d += 1;
        }
        d -= 1;
        k /= 10;
        int di =(int)( nn / k);
        long res = 0;
        if(di > 1) {
            res += counts[d] * di + k;
            res += countIter(nn - (di * k) - 1);
        }else{
            res += nn - (di * k);
            res += countIter(nn - (di * k) - 1);
            res += counts[d];
        }
        return res;
    }
    public static void test(){
        System.out.println(new NumberOfDigitOne().countDigitOne(10));
    }
}
