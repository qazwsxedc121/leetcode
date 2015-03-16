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
        if(num[0] > num[1]){
            return 0;
        }else if(num[n-1] > num[n-2]){
            return n-1;
        }
        int l = 0;
        int r = n - 1;
        int mid = (l + r) / 2;
        while(l < r){
            if(isPeak(num,l)){
                return l;
            }else if(isPeak(num,r)){
                return r;
            }else if(isPeak(num,mid)){
                return mid;
            }else if(num[mid] < num[mid - 1]){
                r = mid - 1;
                mid = (l + r + 1) / 2;
            }else{
                l = mid + 1;
                mid = (l + r - 1) / 2;
            }
        }
        return -1;
    }
    private boolean isPeak(int[] num, int i){
        return i > 0 && i < num.length && num[i] > num[i-1] && num[i] > num[i+1];
    }
    public static void test(){
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(new int[]{3,4,3,2,1}));
    }
}
