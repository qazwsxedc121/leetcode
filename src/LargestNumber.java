import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/20.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        qsort(num, 0, num.length - 1);
        String res = "";
        for(int i = num.length - 1; i > -1; i -= 1){
            res += "" + num[i];
        }
        while(res.charAt(0) == '0' && res.length() > 1){
            res = res.substring(1);
        }
        return res;
    }
    private void qsort(int[] num, int l, int r){
        if(l >= r) return;
        int mid = partition(num, l, r);
        qsort(num, l, mid - 1);
        qsort(num, mid + 1, r);
    }
    private int partition(int[] num, int l, int r){
        if(l >= r){
            return l;
        }
        int pivot = num[r];
        int pl = l;
        for(int i = l; i < r; i += 1){
            if(lt(num[i], pivot)){
                swap(num, pl, i);
                pl += 1;
            }
        }
        swap(num, pl, r);
        return pl;
    }
    private void swap(int[] num, int i, int j){
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }
    public boolean lt(int a,int b){
        long l1 = Long.parseLong(""+a+b);
        long l2 = Long.parseLong(""+b+a);
        return l1 < l2;
    }
    public static void test(){
        LargestNumber l = new LargestNumber();
        System.out.println(l.largestNumber(new int[]{3,30,34,5,2281,2,9}));
    }
}
