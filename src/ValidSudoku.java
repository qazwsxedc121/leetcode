/**
 * User: guoxc
 * Date: 15-1-15
 * Time: 23:09
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean res = true;
        for(int i = 0; i < 9; i += 1){
            char[] t0 = new char[9];
            char[] t1 = new char[9];
            char[] t2 = new char[9];
            for(int j = 0; j < 9; j += 1){
                t0[j] = board[i][j];
                t1[j] = board[j][i];
                int ax = i / 3;
                int ay = i % 3;
                int bx = j / 3;
                int by = j % 3;
                t2[j] = board[3*ax + bx][3*ay + by];
            }
            res = valid(t0) && valid(t1) && valid(t2) && res;
        }
        return res;
    }
    public boolean valid(char[] a){
        boolean[] bitmap = new boolean[10];
        for(int i = 0; i < a.length; i += 1){
            if(a[i] == '.') continue;
            int c = a[i] - '0';
            if(bitmap[c] == true) return false;
            else
                bitmap[c] = true;
        }
        return true;
    }
}
