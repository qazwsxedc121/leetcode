import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2015/3/7.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        m = board.length;
        if(m == 0) return;
        n = board[0].length;
        if(n == 0) return;
        solveOut(board);
        while(!q.isEmpty()){
            int[] top = q.poll();
            checkPoint(board,top[0],top[1]);
        }
        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(board[i][j] == 'r'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private int m = 0;
    private int n = 0;
    private Queue<int[]> q = new LinkedList<int[]>();
    private void solveOut(char[][] board){
        for(int i = 0; i < m; i += 1){
            if(board[i][0] == 'O'){
                board[i][0] = 'r';
                q.add(new int[]{i,0});
            }
            if(board[i][n-1] == 'O'){
                board[i][n-1] = 'r';
                q.add(new int[]{i,n-1});
            }
        }
        for(int i = 0; i < n; i += 1){
            if(board[0][i] == 'O'){
                board[0][i] = 'r';
                q.add(new int[]{0,i});
            }
            if(board[m-1][i] == 'O'){
                board[m-1][i] = 'r';
                q.add(new int[]{m-1,i});
            }
        }
    }

    private void checkPoint(char[][] board, int y, int x){
        if((x == 0 && y == 0) || (x == 0 && y == m-1) || (x == n - 1 && y == 0) || (x == n-1 && y == m-1)){
            return;
        }else if(x == 0){
            check(board, y, x + 1);
        }else if(x == n - 1){
            check(board, y, x - 1);
        }else if(y == 0){
            check(board, y + 1, x);
        }else if(y == m - 1){
            check(board, y - 1, x);
        }else{
            check(board, y, x - 1);
            check(board, y, x + 1);
            check(board, y + 1, x);
            check(board, y - 1, x);
        }

    }
    private void check(char[][]board, int y, int x){
        if(board[y][x] == 'O'){
            board[y][x] = 'r';
            q.add(new int[]{y,x});
        }
    }

    public static void test(){
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = new char[][]{
                {'X','X','X'},
                {'X','O','X'},
                {'X','X','X'}
        };
        s.solve(board);
        return;
    }
}
