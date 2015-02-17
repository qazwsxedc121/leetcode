import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[m];
        for(int i = 0; i < m; i += 1){
            temp[i] = A[i];
        }
        int pa = 0;
        int pb = 0;
        int pi = 0;
        while(pa < m && pb < n){
            if(temp[pa] > B[pb]){
                A[pi] = B[pb];
                pb += 1;
                pi += 1;
            }else{
                A[pi] = temp[pa];
                pa += 1;
                pi += 1;
            }
        }

        while(pa < m){
            A[pi] = temp[pa];
            pa += 1;
            pi += 1;
        }
        while(pb < n){
            A[pi] = B[pb];
            pb += 1;
            pi += 1;
        }
    }
    public static void test(){
        int[] A = new int[]{1,2,3,4,4,5,8,9,0,0,0,0};
        int[] B = new int[]{2,5,10,13};
        MergeSortedArray m = new MergeSortedArray();
        m.merge(A,8,B,4);
        System.out.println(Arrays.toString(A));
    }

}
