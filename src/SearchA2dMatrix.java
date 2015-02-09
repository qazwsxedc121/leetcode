/**
 * Created by Administrator on 2015/2/9.
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int l = 0;
        int r = m - 1;
        int mid = (l + r) / 2;
        while(l <= r){
            if(matrix[mid][0] > target){
                r = mid - 1;
            }else if(matrix[mid][n-1] < target){
                l = mid + 1;
            }else {
                return searchLine(matrix[mid],target);
            }
            mid = (l + r) / 2;
        }
        return false;
    }
    private boolean searchLine(int[] line, int target){
        int n = line.length;
        int l = 0;
        int r = n - 1;
        int mid = (l + r) / 2;
        while(l <= r){
            if(line[mid] == target){
                return true;
            }else if(line[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return false;
    }
    public static void test(){
        SearchA2dMatrix instance = new SearchA2dMatrix();
        int[][] m = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        System.out.println(instance.searchMatrix(m, 7));
    }
}
