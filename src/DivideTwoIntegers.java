/**
 * User: guoxc
 * Date: 15-1-14
 * Time: 22:02
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return  Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1) return Integer.MAX_VALUE;
            else if(divisor == 1) return Integer.MIN_VALUE;

        }
        boolean neg = false;
        long a = dividend;
        long b = divisor;
        if(a < 0){
            neg = !neg;
            a = -a;
        }
        if(b < 0){
            neg = !neg;
            b = -b;
        }
        int res = 0;

        int i = 0;
        long[] tableb = new long[40];
        while(a >= b) {
            tableb[i] = b;
            b = b + b;
            i += 1;
            if(b < 0) break;
        }
        i = i - 1;
        for(;i > -1; i -= 1){
            a = a - tableb[i];
            if(a >= 0) {
                res = res + res + 1;
            }else{
                res = res + res;
                a = a + tableb[i];
            }
        }
        if(neg)
            return  - res;
        else
            return res;
    }
    public static void test(){
        System.out.println(new DivideTwoIntegers().divide(2147483647, 2));
        System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
        System.out.println(new DivideTwoIntegers().divide(-2147483648, -2));
        System.out.println(new DivideTwoIntegers().divide(-2147483648,-2147483648) == 1);
        System.out.println(new DivideTwoIntegers().divide(3647, 3647));
    }
}
