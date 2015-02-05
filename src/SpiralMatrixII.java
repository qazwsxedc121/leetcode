/**
 * Created by Administrator on 2015/2/5.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n){
        int[][] res = new int[n][n];
        int c = 1;
        int xl = 0;
        int xr = n - 1;
        while(c <= (n * n) && xl < xr){
            for(int i = xl; i < xr; i += 1){
                res[xl][i] = c;
                c += 1;
            }
            for(int i = xl; i < xr; i += 1){
                res[i][xr] = c;
                c += 1;
            }
            for(int i = xr; i > xl; i -= 1){
                res[xr][i] = c;
                c += 1;
            }
            for(int i = xr; i > xl; i -= 1){
                res[i][xl] = c;
                c += 1;
            }
            xl += 1;
            xr -= 1;
        }
        if(xl == xr){
            res[xl][xl] = n * n;
        }
        return res;
    }
    public static String matrixToString(int[][] m){
        String res = "";
        for(int i = 0; i < m.length; i += 1){
            for(int j = 0; j < m[0].length; j += 1){
                res += m[i][j] + "";
            }
            res += "\n";
        }
        return res;
    }
    public static void test(){
        SpiralMatrixII instance = new SpiralMatrixII();
        System.out.println(matrixToString(instance.generateMatrix(4)));

    }
}
