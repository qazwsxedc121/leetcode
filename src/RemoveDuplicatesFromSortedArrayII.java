import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-2-13
 * Time: 17:51
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A){
        if(A.length < 2) return A.length;
        int p1 = 1;
        int p2 = 1;
        int state = 1;
        while(p2 < A.length){
            if(A[p1-1] == A[p2]) {
                if (state == 1) {
                    A[p1] = A[p2];
                    p1 += 1;
                    p2 += 1;
                    state += 1;
                } else if (state == 2) {
                    p2 += 1;
                }
            }else{
                A[p1] = A[p2];
                p1 += 1;
                p2 += 1;
                state = 1;
            }
        }
        return p1;
    }
    public static void test(){
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        int[] A = new int[]{1,1,1,2,3,3,4};
        System.out.println(r.removeDuplicates(A));
        System.out.println(Arrays.toString(A));
    }
}
