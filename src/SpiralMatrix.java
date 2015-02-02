import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/1/31.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        if(m == 0)
            return new ArrayList<Integer>();
        int n = matrix[0].length;
        if(n == 0)
            return new ArrayList<Integer>();
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < (m+1)/2 && i < (n+1)/2; i += 1){
            List<Integer> li = spiralOrderLevel(matrix,i,m,n);
            for(int j = 0; j < li.size(); j += 1){
                l.add(li.get(j));
            }
        }
        return l;
    }
    private List<Integer> spiralOrderLevel(int[][] matrix, int lvl, int m, int n){
        List<Integer> res = new ArrayList<Integer>();
        int x = lvl;
        int y = lvl;
        if(m/2 == lvl && n/2 == lvl){
            res.add(matrix[lvl][lvl]);
            return res;
        }else if(m/2 == lvl){
            for(x = lvl; x < n - lvl; x += 1){
                res.add(matrix[lvl][x]);
            }
            return res;
        }else if(n/2 == lvl){
            for(y = lvl; y < m - lvl; y += 1){
                res.add(matrix[y][lvl]);
            }
            return res;
        }else {
            for(x = lvl; x < n - lvl - 1; x += 1) {
                res.add(matrix[lvl][x]);
            }
            for(y = lvl; y < m - lvl - 1; y += 1){
                res.add(matrix[y][n - 1 - lvl]);
            }
            for(x = n - 1 - lvl; x > lvl; x -= 1){
                res.add(matrix[m - 1 - lvl][x]);
            }
            for(y = m - 1 - lvl; y > lvl; y -= 1){
                res.add(matrix[y][lvl]);
            }
            return res;
        }
    }
    public static void test(){
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        SpiralMatrix instance = new SpiralMatrix();
        System.out.println(instance.spiralOrder(matrix));
    }
}
