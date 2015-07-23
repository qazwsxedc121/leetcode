/**
 * User: guoxc
 * Date: 15-7-23
 * Time: 22:57
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int i = 0;
        int j = n - 1;
        while(i < m && j > -1 && matrix[i][j] != target){
            if(matrix[i][j] < target){
                i += 1;
            }else{
                j -= 1;
            }
        }
        if(i == m || j == -1) return false;
        return true;
    }
}
