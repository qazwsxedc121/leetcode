import java.util.Arrays;

/**
 * Created by Administrator on 2015/2/8.
 */
public class PlusOne {
    public int[] plusOne(int[] digits){
        int n = digits.length;
        int i = n - 1;
        int[] res = new int[n+1];
        while(i > -1 && digits[i] == 9){
            res[i+1] = 0;
            i -= 1;
        }
        if(i == -1){
            res[0] = 1;
            return res;
        }
        res[i+1] = digits[i] + 1;
        i -= 1;
        while(i > -1){
            res[i+1] = digits[i];
            i -= 1;
        }
        int[] newRes = new int[n];
        for(i = 0; i < n; i += 1){
            newRes[i] = res[i+1];
        }
        return newRes;
    }
    public static void test(){
        PlusOne instance = new PlusOne();
        System.out.println(Arrays.toString(instance.plusOne(new int[]{9,9,9})));
        System.out.println(Arrays.toString(instance.plusOne(new int[]{2,3,4})));
    }
}
