import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Administrator on 2015/3/14.
 */
public class MaximalRectangle {
    private int m;
    private int n;
    private char[][] mat;
    private int[][] dirR;
    private int[][] dirB;
    public int maximalRectangle(char[][] matrix) {
        m = matrix.length;
        if(m == 0) return 0;
        n = matrix[0].length;
        if(n == 0) return 0;
        mat = matrix;
        dirR = new int[m][n];
        dirB = new int[m][n];
        preProcess();
        int maxArea = 0;
        for(int i = 0; i < m; i += 1){
            int area = maxInline(i);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    private void preProcess(){
        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(dirR[i][j] == 0 && mat[i][j] == '1'){
                    int k = j + 1;
                    int c = 1;
                    while(k < n && mat[i][k] == '1'){
                        c += 1;
                        k += 1;
                    }
                    for(int l = j; l < k; l += 1){
                        dirR[i][l] = c;
                        c -= 1;
                    }
                }
                if(dirB[i][j] == 0 && mat[i][j] == '1'){
                    int k = i + 1;
                    int c = 1;
                    while(k < m && mat[k][j] == '1'){
                        c += 1;
                        k += 1;
                    }
                    for(int l = i; l < k; l += 1){
                        dirB[l][j] = c;
                        c -= 1;
                    }
                }
            }
        }
    }
    private int maxInline(int y){
        int[] d = new int[n+2];
        for(int i = 0; i < n; i += 1){
            d[i + 1] = dirB[y][i];
        }
        d[0] = -1;
        d[n+1] = -1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(-1);
        int maxArea = 0;
        for(int i = 0; i < n + 1 ; i += 1){
            if(stack.empty() || d[i+1] > d[stack.peek()+1]){
                stack.add(i);
                continue;
            }

            while(d[i+1] < d[stack.peek()+1]){
                int k = stack.pop();
                int v = stack.peek();
                int area = (i - v - 1) * d[k + 1];
                if(area > maxArea){
                    maxArea = area;
                }
            }
            stack.add(i);

        }
        return maxArea;
    }
    public static void test(){
        MaximalRectangle m = new MaximalRectangle();
        char[][] matrix0 = new char[][]{
                {'1'}
        };
        char[][] matrix1 = new char[][]{
                {'1','1','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'}
        };
        System.out.println(m.maximalRectangle(matrix1));
    }
}
