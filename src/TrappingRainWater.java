import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-23
 * Time: 18:13
 */
public class TrappingRainWater {
    public int trap(int[] A){
        if(A.length == 0) return 0;
        int max = 0;
        int max_i = 0;
        for(int i = 0; i < A.length; i += 1){
            if(A[i] > max){
                max = A[i];
                max_i = i;
            }
        }
        int i = 0;
        int b = A[i];
        int w = 0;
        while(i < max_i){
            if(A[i] >= b){
                b = A[i];
            }else{
                w += b - A[i];
            }
            i += 1;
        }
        i = A.length - 1;
        b = A[i];
        while(i > max_i){
            if(A[i] >= b){
                 b = A[i];
            }else{
                w += b - A[i];
            }
            i -= 1;
        }
        return w;

    }
//    public int trap(int[] A){
//        int res = 0;
//        int max = 0;
//        int[] B = new int[A.length];
//        for(int i = 0; i < B.length; i += 1){
//            B[i] = A[i];
//        }
//        Arrays.sort(B);
//        int last = 0;
//        for(int l = 1; l < B.length; l += 1){
//            if(B[l] == last) continue;
//            res += (B[l] - last) * trapLevel(A,B[l]);
//            last = B[l];
//        }
//        return res;
//    }
//    public int trapLevel(int[] A, int level){
//        int res = 0;
//        int l = 0;
//        int r = A.length - 1;
//        while(l < r && A[l] < level){
//            l += 1;
//        }
//        while(l < r && A[r] < level){
//            r -= 1;
//        }
//        for(int i = l + 1; i < r; i += 1){
//            if(A[i] < level){
//                res += 1;
//            }
//        }
//        return res;
//    }
    public static void test(){
        TrappingRainWater instance = new TrappingRainWater();
        System.out.println(instance.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
