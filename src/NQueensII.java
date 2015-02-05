/**
 * User: guoxc
 * Date: 15-2-2
 * Time: 21:45
 */
public class NQueensII {
    public int totalNQueens(int n){
        int[] board = new int[n];
        return queens(board, 0, n);

    }
    private int queens(int[] board,int filledLen, int n){
        if(filledLen == n) return 1;
        int c = 0;
        for(int i = 0; i < n; i += 1){
            board[filledLen] = i;
            if(validQueen(board, filledLen)) {
                c += queens(board, filledLen + 1, n);
            }
        }
        return c;
    }
    private boolean validQueen(int[] board, int len){
        int x = board[len];
        for(int i = 0; i < len; i += 1){
            if(board[i] == x || board[i] - x == len - i || board[i] - x == i - len)
                return false;
        }
        return true;
    }
    public static void test(){
        NQueensII instance = new NQueensII();
        NQueens instance2 = new NQueens();
        System.out.println(instance.totalNQueens(6) == instance2.solveNQueens(6).size());
    }
}
