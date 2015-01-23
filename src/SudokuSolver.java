import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

/**
 * User: guoxc
 * Date: 15-1-20
 * Time: 15:39
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board){
        dfs(board, 0);
        return;
    }
    public boolean dfs(char[][] board, int pos){
        if(pos == 81) return true;
        int x = pos % 9;
        int y = pos / 9;
        if(board[y][x] == '.'){
            for(char c = '1'; c <= '9'; c += 1){
                board[y][x] = c;
                if(valid(board, pos) && dfs(board, pos + 1)){
                    return true;
                }
                board[y][x] = '.';
            }
            return false;
        }else{
            return dfs(board, pos + 1);
        }
    }
    public boolean valid(char[][] board, int pos){
        int x = pos % 9;
        int y = pos / 9;
        int col_index = x / 3;
        int row_index = y / 3;
        char charPos = board[y][x];
        for(int i = 0; i < 9; i += 1){
            if(charPos == board[row_index * 3 + i / 3][col_index * 3 + i % 3] &&
                    pos != (row_index * 3 + i / 3) * 9 + col_index * 3 + i % 3){
                return false;
            }
            if(charPos == board[y][i] && pos != y * 9 + i){
                return false;
            }
            if(charPos == board[i][x] && pos != i * 9 + x){
                return false;
            }
        }
        return true;

    }
//    HashMap<Integer,Set<Integer>> t;
//    int round = 0;
//
//    public void solveSudoku(char[][] board){
//        t = new HashMap<Integer, Set<Integer>>();
//        getTemp(board);
//        round = 1;
//        while(t.size() > 0){
//            printBoard(board);
//            Iterator<Integer> r = t.keySet().iterator();
//
//            while(r.hasNext()){
//                int k = r.next();
//                if(t.get(k).size() == 1){
//                    char toFill = (char)(t.get(k).iterator().next() + '0');
//                    board[k / 9][k % 9] = toFill;
//                }
//            }
//            r = t.keySet().iterator();
//            ArrayList<Integer> keysToRemove = new ArrayList<Integer>();
//            while(r.hasNext()){
//                int k = r.next();
//                if(t.get(k).size() <= 1){
//                    keysToRemove.add(k);
//                }
//            }
//            for(int i = 0; i < keysToRemove.size(); i += 1){
//                t.remove(keysToRemove.get(i));
//            }
//            printBoard(board);
//            getTemp(board);
//            round += 1;
//        }
//    }
//    private void getTemp(char[][] board){
//        for(int i = 0; i < 9; i += 1){
//            for(int j = 0; j < 9; j += 1){
//                if(board[i][j] == '.'){
//                    t.put((i * 9) + j, possibleNum(board,j,i));
//                }
//            }
//        }
//    }
//    public Set<Integer> possibleNum(char[][] board, int x, int y){
//        boolean[] intmap = new boolean[9];
//        int row_index = y / 3;
//        int col_index = x / 3;
//        for(int i = 0; i < 9; i += 1){
//            int c = board[y][i] - '1';
//            if(c > -1 && c < 9)
//                intmap[c] = true;
//            c = board[i][x] - '1';
//            if(c > -1 && c < 9)
//                intmap[c] = true;
//            c = board[(row_index * 3) + (i / 3)][(col_index * 3) + (i % 3)] - '1';
//            if(c > -1 && c < 9)
//                intmap[c] = true;
//        }
//        Set<Integer> res = new HashSet<Integer>();
//        for(int i = 0; i < 9; i += 1){
//            if(!intmap[i])
//                res.add(i+1);
//        }
//        int index_m = y * 9 + x;
//        if(res.size()>1 && round > 1){
//            Iterator<Integer> ir = res.iterator();
//
//            while(ir.hasNext()){
//                int charnow = ir.next();
//                boolean only = true;
//                for (int i = 0; i < 9; i += 1) {
//                    int yi = (row_index * 3) + (i / 3);
//                    int xi = (col_index * 3) + (i % 3);
//                    int index = yi * 9 + xi;
//
//                    if (index != index_m && t.containsKey(index)) {
//                        if(t.get(yi * 9 + xi).contains(charnow)){
//                            only = false;
//                        }
//                    }
//                }
//                if(only){
//                    Set<Integer> s = new HashSet<Integer>();
//                    s.add(charnow);
//                    t.put((y*9)+x,s);
//                    return s;
//                }
//            }
//        }
//        return res;
//    }
    public void printBoard(char[][] board){
        System.out.println("-----------------");
        String r = "";
        for(int i = 0; i < 9; i += 1){
            for(int j = 0; j < 9; j += 1){
                r += board[i][j] + " ";
            }
            r += "\n";
        }
        System.out.print(r);
    }
    public char[][] toBoard(String[] b){
        char[][] res = new char[9][];
        for(int i = 0 ; i < 9; i += 1){
            res[i] = b[i].toCharArray();
        }
        return res;
    }
    public static void test(){
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        String[] b = new String[]{
            "..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."
        };

        SudokuSolver instance = new SudokuSolver();

//        instance.solveSudoku(board);
        board = instance.toBoard(b);
        instance.printBoard(board);
        instance.solveSudoku(board);
        instance.printBoard(board);
    }
}
