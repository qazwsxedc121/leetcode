/**
 * Created by Administrator on 2015/2/9.
 */
public class Sqrtx {
    public int sqrt(int x){
        if(x <= 0)
            return 0;
        long guess = x / 2;
        if(guess == 0) return 1;
        long l = guess * guess;
        long u = (guess + 1) * (guess + 1);
        while( x < l || x >= u){
            guess = (guess + x / guess) / 2;
            l = guess * guess;
            u = (guess + 1) * (guess + 1);
        }
        return (int)guess;
    }
    public static void test(){
        Sqrtx instance = new Sqrtx();
        System.out.println(instance.sqrt(2147395600));
    }
}
