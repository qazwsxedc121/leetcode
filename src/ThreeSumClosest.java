import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-9
 * Time: 16:35
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target){
        int min = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i += 1){
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                int c = num[i] + num[j] + num[k] - target;
                int absc = c < 0 ? -c : c;
                if(absc < min){
                    min = absc;
                    res = c + target;
                }
                if (c < 0) {
                    j += 1;
                }else if (c > 0){
                    k -= 1;
                }else{
                    break;
                }
            }
        }
        return res;
    }
    public static void test(){
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}
