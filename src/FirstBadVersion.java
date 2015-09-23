/**
 * Created by Administrator on 2015/9/23.
 */
public class FirstBadVersion {
    private boolean isBadVersion(int i){
        return true;
    }
    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        if(!isBadVersion(n)) return n + 1;
        long l = 1;
        long r = n;
        long mid = (l + r) / 2;
        while(l < r){
            mid = (l + r) / 2;
            if(isBadVersion((int)mid)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(isBadVersion((int)l)){
            return (int)l;
        }else{
            return (int)l + 1;
        }
    }
}
