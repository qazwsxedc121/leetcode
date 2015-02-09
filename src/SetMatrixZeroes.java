/**
 * Created by Administrator on 2015/2/9.
 */
public class SetMatrixZeroes {
    public void setZeros(int[][] matrix){
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        if(n == 0) return;
        int row0 = -1;
        int col0 = -1;
OUTER:  for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(matrix[i][j] == 0){
                    row0 = i;
                    col0 = j;
                    break OUTER;
                }
            }
        }
        if(row0 == -1) return;
        for(int i = 0; i < m; i += 1){
            if(matrix[i][col0] == 0){
                matrix[i][col0] = 1;
            }else {
                matrix[i][col0] = 0;
            }
        }
        for(int i = 0; i < n; i += 1){
            if(matrix[row0][i] == 0){
                matrix[row0][i] = 1;
            }else {
                matrix[row0][i] = 0;
            }
        }
        for(int i = 0; i < m; i += 1){
            if(i == row0) continue;
            for(int j = 0; j < n; j += 1){
                if(j == col0) continue;
                if(matrix[i][j] == 0){
                    matrix[i][col0] = 1;
                    matrix[row0][j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i += 1){
            if(matrix[i][col0] == 1){
                for(int j = 0; j < n; j += 1){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < n; i += 1){
            if(matrix[row0][i] == 1){
                for(int j = 0; j < m; j += 1){
                    matrix[j][i] = 0;
                }
            }
        }
        return;
    }
    private static String m2str(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        String res = "";
        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                res += matrix[i][j];
            }
            res += "\n";
        }
        return res;
    }
    public static void test(){
        SetMatrixZeroes instance = new SetMatrixZeroes();
        int[][] m = new int[][]{
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}
        };
        instance.setZeros(m);
        System.out.println(m2str(m));
    }
}
