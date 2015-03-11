/**
 * Created by Administrator on 2015/3/10.
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candyR = new int[n];
        for(int i = 0; i < n; i += 1){
            candyR[i] = 1;
        }
        for(int i = 1; i < n; i += 1){
            if(ratings[i] > ratings[i-1]){
                candyR[i] = candyR[i-1] + 1;
            }
        }
        for(int i = n - 2; i > -1; i -= 1){
            if(ratings[i] > ratings[i + 1]){
                candyR[i] = candyR[i] > candyR[i+1] + 1 ? candyR[i] : candyR[i+1] + 1;
            }
        }
        int res = 0;
        for(int i = 0; i < n; i += 1){
            res += candyR[i];
        }
        return res;
    }
    public static void test(){
        Candy c = new Candy();
        System.out.println(c.candy(new int[]{2,3,3,3,2,1}));
        System.out.println(c.candy(new int[]{2,2,1}));
    }
}
