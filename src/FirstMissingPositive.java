import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-23
 * Time: 16:39
 */
// solution from http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A){
        if(A.length == 0) return 1;
        for(int i = 0; i < A.length; i += 1){
            while(A[i] > 0 && A[i] <= i + 1 && A[A[i] - 1] != A[i]){
                swap(A, A[i] - 1, i);
            }

        }
        int i = 0;
        int res = 1;
        while (i < A.length && A[i] == i + 1 ){
            res += 1;
            i += 1;
        }
        return res;
    }
    public void swap(int[] A, int i, int j){
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
        return;
    }
    public static void test(){
        FirstMissingPositive instance = new FirstMissingPositive();
        System.out.println(instance.firstMissingPositive(new int[]{9, 7, 5, 3, 1, 4, 2, 6, -1, 1}));
    }
}
