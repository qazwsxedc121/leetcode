/**
 * User: guoxc
 * Date: 15-1-28
 * Time: 18:01
 */
public class RotateImage {
    public void rotate(int[][]matrix){
        int n = matrix.length;
        for(int i = 0; i < (n/2); i += 1){
            rotateBorder(matrix,i,n);
        }
        return;
    }
    private void rotateBorder(int[][]matrix, int lvl, int n){
        for(int i = 0; i < (n - 1) - (2 * lvl); i += 1){
            rotatePoint(matrix,lvl, i,n);
        }
        return;
    }
    private void rotatePoint(int[][]matrix, int lvl, int x, int n){
        int p1x = x + lvl;
        int p1y = lvl;
        int p2x = n - 1 - lvl;
        int p2y = lvl + x;
        int p3x = n - 1 - lvl - x;
        int p3y = n - 1 - lvl;
        int p4x = lvl;
        int p4y = n - 1 - lvl - x;
        int temp = matrix[p4y][p4x];
        matrix[p4y][p4x] = matrix[p3y][p3x];
        matrix[p3y][p3x] = matrix[p2y][p2x];
        matrix[p2y][p2x] = matrix[p1y][p1x];
        matrix[p1y][p1x] = temp;
        return;
    }
    public String matrixToString(int[][]matrix){
        String res = "";
        for(int i = 0; i < matrix.length; i += 1){
            for(int j = 0; j < matrix[i].length; j += 1){
                res += matrix[i][j] + ",";
            }
            res += "\n";
        }
        return res;
    }
    public static void test(){
        RotateImage instance = new RotateImage();
        int[][] m = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        instance.rotate(m);
        System.out.println(instance.matrixToString(m));
    }
}
