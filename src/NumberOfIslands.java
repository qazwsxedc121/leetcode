import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2015/4/9.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid){
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        int res = 0;
        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(grid[i][j] == '1'){
                    res += 1;
                    destoryIsland(grid,j,i);
                }
            }
        }
        return res;
    }
    private void destoryIsland(char[][] grid, int x, int y){
        Queue<Integer> q = new LinkedList<Integer>();
        int m = grid.length;
        int n = grid[0].length;
        q.add(y*n + x);
        grid[y][x] = '0';
        while(!q.isEmpty()){
            System.out.print(".");
            int top = q.poll();
            int topx = top % n;
            int topy = top / n;
            if(topx != n - 1 && grid[topy][topx + 1] == '1'){
                q.add(topy * n + topx + 1);
                grid[topy][topx + 1] = '0';
            }
            if(topx != 0 && grid[topy][topx - 1] == '1'){
                q.add(topy * n + topx - 1);
                grid[topy][topx - 1] = '0';
            }
            if(topy != m - 1 && grid[topy + 1][topx] == '1'){
                q.add((topy + 1) * n + topx);
                grid[topy + 1][topx] = '0';
            }
            if(topy != 0 && grid[topy - 1][topx] == '1'){
                q.add((topy - 1) * n + topx);
                grid[topy - 1][topx] = '0';
            }
        }
    }
    public static void test(){
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()}));
    }
}
