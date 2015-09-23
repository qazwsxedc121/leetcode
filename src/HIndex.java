import java.util.Arrays;

/**
 * Created by Administrator on 2015/9/23.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        if(n == 0) return 0;
        int i = 0;
        for(i = 0; i < n; i += 1){
            if(citations[n-1-i] <= i){
                break;
            }
        }
        return i;
    }
}
