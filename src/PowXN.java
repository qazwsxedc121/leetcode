/**
 * Created by Administrator on 2015/1/29.
 */
public class PowXN {
    public double pow(double x, int n){
        if(n == Integer.MIN_VALUE){
            return pow(1 / x, n - 2) * pow(1 / x, 2);
        }else if(n < 0){
            return pow( 1 / x, -n);
        }else if(n == 0)
            return 1;
        else if(n == 1)
            return x;
        else if(n % 2 == 0){
            double p = pow(x, n / 2);
            return p * p;
        }else{
            return x * pow(x, n - 1);
        }
    }
    public static void test(){
        PowXN instance = new PowXN();
        System.out.println(instance.pow(1.00000, Integer.MIN_VALUE));
    }
}
