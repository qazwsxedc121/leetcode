/**
 * User: guoxc
 * Date: 14-10-13
 * Time: 18:00
 */

// Solution from:     http://www.cnblogs.com/TenosDoIt/p/3675220.html
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length ;
        int n = B.length ;
        if(m == 0){
            if(n % 2 == 0){
                return (B[n/2] + B[n/2 - 1]) * 1.0 / 2;
            }else{
                return B[n/2];
            }
        }else if(n == 0){
            if(m % 2 == 0){
                return (A[m/2] + A[m/2 - 1]) * 1.0 / 2;
            }else{
                return A[m/2];
            }
        }
        if((m+n) % 2 == 0){
            return (kSmallest(A,0,A.length,B,0,B.length,(m+n)/2) + kSmallest(A,0,A.length,B,0,B.length,((m+n)/2) + 1)) * 1.0 / 2;
        }else{
            return kSmallest(A,0,A.length, B,0,B.length, (m+n+1)/2);
        }
    }

    public int kSmallest(int A[], int a1, int a2, int B[], int b1, int b2, int k){
        System.out.println(a1+","+a2+" "+b1+","+b2+" "+k);
        if(a1 == a2){
            return B[b1 + k - 1];
        }else if(b1 == b2){
            return A[a1 + k - 1];
        }
        if(k <= 1){
            if(A[a1] > B[b1]){
                return B[b1];
            }else{
                return A[a1];
            }
        }
        int n1 = a2 - a1;
        int n2 = b2 - b1;
        int idx1 = (int) (n1 * 1.0 / (n1 + n2) * (k - 1));
        int idx2 = k - idx1 - 2;
        System.out.println("idx1="+idx1+",idx2="+idx2);
        if(A[idx1 + a1] == B[idx2 + b1]){
            return A[idx1 + a1];
        }else if(A[idx1 + a1] > B[idx2 + b1]){
            return kSmallest(A, a1, a1 + idx1 + 1, B, b1 + idx2 + 1, b2, k - idx2 - 1);
        }else{
            return kSmallest(A, a1 + idx1 + 1, a2, B, b1, b1 + idx2 + 1, k - idx1 - 1);
        }
    }
    public static void test(){
        int A[]= new int[]{1,2};
        int B[]= new int[]{1,2,3};
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        System.out.println(motsa.findMedianSortedArrays(A,B));
    }
}
