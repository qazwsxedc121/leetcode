import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-13
 * Time: 15:57
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem){
        if(A.length == 0) return 0;
        int i = 0;
        int j = A.length - 1;
        while(i <= j){
            while(j >= 0 && A[j] == elem){
                j -= 1;
            }
            while(i < A.length && A[i] != elem){
                i += 1;
            }
            if(i < j) {
                // A[i] == element && A[j] != element
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return j + 1;
    }
    public static void test(){
        RemoveElement instance = new RemoveElement();
        int[] A = new int[]{3};
        int res = instance.removeElement(A , 3);
        System.out.println(Arrays.toString(A));
        System.out.println(res);
    }
}
