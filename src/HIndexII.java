/**
 * Created by Administrator on 2015/9/23.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;
        if(n == 1){
            return citations[0] > 0 ? 1 : 0;
        }
        int l = 0;
        int r = n - 1;
        int mid = 0;
        while(l < r){
            mid = (l + r) / 2;
            if(citations[mid] == n - mid){
                return n - mid;
            }else if(citations[mid] > n - mid){
                r -= 1;
            }else{
                l += 1;
            }
        }
        if(citations[l] < n - l){
            return n - l - 1;
        }else{
            return n - l;
        }
    }
}
