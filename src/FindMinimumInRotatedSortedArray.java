/**
 * Created by Administrator on 2015/3/15.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        return findMinIn(num, 0, num.length - 1);
    }
    private int findMinIn(int[] num, int l, int r){
        if(l == r){
            return num[l];
        }else if(r - l == 1){
            return num[l] < num[r] ? num[l] : num[r];
        }
        int mid = (l + r) / 2;
        if(num[mid] > num[l] && num[mid] > num[r]){
            return findMinIn(num, mid,r);
        }else {
            return findMinIn(num, l, mid);
        }
    }
}
