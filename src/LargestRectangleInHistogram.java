
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

/**
 * User: guoxc
 * Date: 15-2-14
 * Time: 12:58
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack();

        int n = height.length;
        if(n == 0) return 0;
        int[] h = new int[n+1];
        for(int i = 0; i < n; i += 1){
            h[i] = height[i];
        }
        h[n] = -1;
        int max_area = 0;
        for(int i = 0; i < n+1; i += 1){
            if(s.empty() || h[i] > h[s.peek()]){
                s.push(i);
            }else{
                while(!s.empty() && h[i] < h[s.peek()]){
                    int k = s.pop();
                    int area = 0;
                    if(s.empty()) {
                        area = i * h[k];
                    }else{
                        area = (i - s.peek() -1) * h[k];
                    }
                    if(area > max_area){
                        max_area = area;
                    }
                }
                s.push(i);
            }
        }
        return max_area;
    }
    public static void test(){
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
//        System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
//        System.out.println(l.largestRectangleArea(new int[]{1,2,3,4,5,6}));
        System.out.println(l.largestRectangleArea(new int[]{4,2,0,3,2,5}));
    }
}
