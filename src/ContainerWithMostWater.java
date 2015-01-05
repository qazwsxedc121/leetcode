import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-5
 * Time: 18:11
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int max = 0;
        int h_len = height.length;
        int[] ls = new int[height.length];
        for(int i = 0; i < height.length; i += 1){
            ls[i] = height[i];
        }
        Arrays.sort(ls);
        int old_l = 0;
        int old_r = ls.length - 1;
        for(int i = 0; i < ls.length - 1; i += 1){
            int h = ls[i];
            int l = old_l;
            int r = old_r;
            for(l = old_l; l < r; l += 1){
                if(height[l] >= h) break;
            }
            for(r = old_r; r > l; r -= 1){
                if(height[r] >= h) break;
            }
            int a = area(height, l, r);
            old_l = l;
            old_r = r;
            if(a > max){
                max = a;
            }
        }
        return max;
    }
    public int maxArea_slow(int[] height){
        int max = 0;
        int h_len = height.length;
        for(int i = 0; i < h_len; i += 1){
            for(int j = i + 1; j < h_len; j += 1){
                int a = area(height, i, j);
                if(a > max){
                    max = a;
                }
            }
        }
        return max;
    }
    public int area(int[] height, int a,int b){
        int h = height[b] > height[a] ? height[a] : height[b];
        int w = b - a;
        return h * w;
    }
    public static void test(){
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{2, 1}));
    }
}
