import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-13
 * Time: 15:42
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A){
        if(A.length == 0) return 0;
        int i = 0;
        int j = 0;
        while(i < A.length) {
            while (i < A.length && A[i] == A[j]) {
                i += 1;
            }
            if(i < A.length) {
                j += 1;
                A[j] = A[i];
            }
        }
        return j+1;
    }
    public static void test(){
        RemoveDuplicatesFromSortedArray instance = new RemoveDuplicatesFromSortedArray();
        int[] A = new int[]{1,1,2,3,3,3,3,3,3,4,4,5,6,6,6};
        int res = instance.removeDuplicates(A);
        System.out.println(Arrays.toString(A));
        System.out.println(res);
    }
}
