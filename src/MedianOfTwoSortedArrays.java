/**
 * User: guoxc
 * Date: 14-10-13
 * Time: 18:00
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length - 1;
        int n = B.length - 1;
        return this.findIter(A,0,m,B,0,n);
    }
    public int findIter(int A[], int a1, int a2, int B[], int b1, int b2){
        System.out.println(a1 + "," + a2 + "," + b1 + "," + b2);
        if(a1 >= a2){
            return A[a2];
        }else if(b1 >= b2){
            return B[b2];
        }
        int p = (a1 + a2) / 2;
        int q = (b1 + b2) / 2;
        if(A[p] > B[q]){
            return this.findIter(A,a1,p,B,q,b2);
        }else{
            return this.findIter(A,p,a2,B,b1,q);
        }
    }
    public static void test(){
        int A[]= new int[]{1,3,5,7,8,9,10};
        int B[]= new int[]{2,4,6,10,11,12,13,14,17,19,20};
        MedianOfTwoSortedArrays tc = new MedianOfTwoSortedArrays();
        System.out.print(tc.findMedianSortedArrays(A,B));
    }
}
