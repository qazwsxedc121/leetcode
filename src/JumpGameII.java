import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * User: guoxc
 * Date: 15-1-27
 * Time: 16:39
 */
public class JumpGameII {
    public int jump(int[] A){
        int n = A.length;
        if(n == 1) return 0;
        int jumpCounter = 0;
        int last = 0;
        int curr = A[0];
        for(int i = 1; i < n; i += 1){
            if(i > curr){
                return -1;
            }
            if(i > last){
                jumpCounter += 1;
                last = curr;
            }
            if(i + A[i] > curr){
                curr = i + A[i];
            }
        }
        return jumpCounter;


    }
    public static void test(){
        JumpGameII instance = new JumpGameII();
        System.out.println(instance.jump(new int[]{2,2,2,2,2,2,0}));
        System.out.println(instance.jump(new int[]{2,3,1,1,4}));
    }
}
