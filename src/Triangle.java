import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-3-4
 * Time: 15:09
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i += 1){
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for(int j = i - 1; j > 0; j -= 1){
                dp[j] = dp[j] > dp[j - 1] ? dp[j - 1] : dp[j];
                dp[j] += triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int min = dp[0];
        for(int i = 1; i < n; i += 1){
            if(dp[i] < min){
                min = dp[i];
            }
        }
        return min;
    }
    public static void test(){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(new Triangle().minimumTotal(triangle));
        triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2,3));
        triangle.add(Arrays.asList(1,-1,-3));
        System.out.println(new Triangle().minimumTotal(triangle));


    }
}
