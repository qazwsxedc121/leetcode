import java.util.Arrays;

/**
 * Created by Administrator on 2015/2/10.
 */
public class SortColors {
    public void sortColors(int[] A){
        if(A.length <= 1) return;
        int p0 = 0;
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < A.length; i += 1){
            if(A[i] == 0){
                A[p2] = 2;
                p2 += 1;// two section move right 1
                A[p1] = 1;
                p1 += 1;// one section move right 1
                A[p0] = 0;
                p0 += 1;// zero section move right 1
            }else if(A[i] == 1){
                A[p2] = 2;
                p2 += 1;
                A[p1] = 1;
                p1 += 1;
            }else{
                A[p2] = 2;
                p2 += 1;
            }
        }
        return;
    }
    public static void test(){
        SortColors s = new SortColors();
        int[] A = new int[]{1,2,0,1,2,0};
        s.sortColors(A);
        System.out.println(Arrays.toString(A));
    }
}
