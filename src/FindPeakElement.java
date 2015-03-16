/**
 * Created by Administrator on 2015/3/17.
 */
public class FindPeakElement {
    public int findPeakElement(int[] num){
        int n = num.length;
        if(n == 0){
            return -1;
        }else if(n == 1){
            return 0;
        }
        if(num[1] < num[0]){
            return 0;
        }
        if(num[n-1] > num[n-2]){
            return n-1;
        }
        for(int i = 1; i < n - 1; i += 1){
            if(num[i] > num[i - 1] && num[i] > num[i + 1]){
                return i;
            }
        }
        return -1;
    }
}
