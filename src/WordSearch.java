/**
 * Created by Administrator on 2015/2/12.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word){
        int m = board.length;
        if(m == 0) return word.isEmpty();
        int n = board[0].length;
        if(n == 0) return word.isEmpty();
        boolean flag = false;
        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                boolean exist = existFrom(board, i, j, word, 0);
                if(exist){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    private boolean existFrom(char[][] board, int y, int x, String word, int wi){
        int m = board.length;
        int n = board[0].length;
        if(word.isEmpty()) return true;
        if(board[y][x] == word.charAt(wi)){
            if(wi == word.length() - 1){
                return true;
            }else{
                char t = board[y][x];
                board[y][x] = '.';
                boolean res1 = y > 0 ? existFrom(board, y - 1, x, word, wi + 1) : false;
                if(res1){
                    board[y][x] = t;
                    return true;
                }
                boolean res2 = y < m - 1 ? existFrom(board, y + 1, x, word, wi + 1) : false;
                if(res2){
                    board[y][x] = t;
                    return true;
                }
                boolean res3 = x > 0 ? existFrom(board, y, x - 1, word, wi + 1) : false;
                if(res3){
                    board[y][x] = t;
                    return true;
                }
                boolean res4 = x < n - 1 ? existFrom(board, y, x + 1, word, wi + 1) : false;
                board[y][x] = t;
                return res4;
            }
        }else {
            return false;
        }
    }
    public static void test(){
        WordSearch w = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(w.exist(board,"ABCCED"));
        System.out.println(w.exist(board,"SEE"));
        System.out.println(w.exist(board,"ABCB"));
    }
}
