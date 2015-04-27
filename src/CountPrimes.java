/**
 * Created by Administrator on 2015/4/27.
 */
public class CountPrimes {
    public int countPrimes(int n){
        if(n <= 2){
            return 0;
        }else if(n == 3){
            return 2;
        }
        boolean[] isNotPrime = new boolean[n];
        int res = 0;
        int i = 2;
        while (i < n) {
            if(!isNotPrime[i]){
                res += 1;
                for(int j = 2 * i; j < n; j += i){
                    isNotPrime[j] = true;
                }
            }
            i += 1;
        }
        return res;
    }
    public static void test(){
        System.out.println(new CountPrimes().countPrimes(5000000));
    }
}
