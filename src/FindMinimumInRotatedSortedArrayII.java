/**
 * Created by Administrator on 2015/3/15.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num){
        return findMinIn(num, 0, num.length - 1);
    }
    private int findMinIn(int[] num, int l, int r){
        while(l < r && num[l] == num[l + 1]){
            l += 1;
        }
        while(l < r && num[r] == num[r - 1]){
            r -= 1;
        }
        if(l == r){
            return num[l];
        }else if(r - l == 1){
            return min(num[l],num[r]);
        }
        int mid = (l + r) / 2;
        if(num[mid] == num[l] && num[mid] == num[r]){
            return min(findMinIn(num, l, mid - 1), findMinIn(num, mid + 1, r));
        }else if(num[mid] == num[l]){
            return findMinIn(num, mid, r);
        }else if(num[mid] == num[r]){
            return findMinIn(num, l, mid);
        }
        if(num[mid] > num[l] && num[mid] > num[r]){
            return findMinIn(num,mid,r);
        }else {
            return findMinIn(num, l, mid);
        }
    }
    private int min(int a, int b){
        return a < b ? a : b;
    }
}
