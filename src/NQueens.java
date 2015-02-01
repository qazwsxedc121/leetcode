import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/2/1.
 */
public class NQueens {
    public List<String[]> solveNQueens(int n ){
        boolean[][] board = new boolean[n][n];
        result = new ArrayList<>();
        this.n = n;
        solve(board,0);
        return result;
    }
    public List<String[]> result;
    public int n;
    private void solve(boolean[][] board,int y){
        for(int i = 0; i < n; i += 1){
            board[y][i] = true;
            boolean valid = acceptQueens(board, i, y);
            if(y == n - 1 && valid){
                addBoard(board);
            }else if(valid){
                solve(board, y + 1);
            }
            board[y][i] = false;
        }
    }
    private boolean acceptQueens(boolean[][] board, int x,int y){
        boolean flag = true;
        for(int i = y - 1; i >= 0; i -= 1){
            if(board[i][x]) {
                flag = false;
                break;
            }
        }
        if(!flag) return false;
        for(int i = 1; x - i >= 0 && y - i >= 0; i += 1){
            if(board[y-i][x-i]) {
                flag = false;
                break;
            }
        }
        if(!flag) return false;
        for(int i = 1; x + i < n && y - i >= 0; i += 1){
            if(board[y-i][x+i]){
                flag = false;
                break;
            }
        }
        return flag;
    }
    private void addBoard(boolean[][] board){
        String[] l = new String[n];
        for(int i = 0; i < n; i += 1){
            String s = "";
            for(int j = 0; j < n; j += 1){
                if(board[i][j]){
                    s += "Q";
                }else{
                    s += ".";
                }
            }
            l[i] = s;
        }
        result.add(l);
    }
    private static String queensToString(List<String[]> r){
        String res = "";
        for(int i = 0; i < r.size(); i += 1){
            String[] l = r.get(i);
            for(int j = 0; j < l.length; j += 1){
                res += l[j] + "\n";
            }
            res += "---------------\n";
        }
        return res;
    }
    public static void test(){
        NQueens instance = new NQueens();
        System.out.println(queensToString(instance.solveNQueens(4)));
    }
}
