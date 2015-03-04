import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/3/4.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        Integer[] dp = new Integer[rowIndex];
        dp[0] = 1;
        for(int i = 1; i < rowIndex; i += 1){
            dp[i] = 1;
            for(int j = i - 1; j > 0; j -= 1){
                dp[j] = dp[j] + dp[j-1];
            }
            dp[0] = 1;
        }
        return Arrays.asList(dp);
    }
}
