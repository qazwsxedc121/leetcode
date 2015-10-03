class Solution {
private:
    bool isValid(vector<vector<char>>& board, int y, int x){
        char c = board[y][x];
        for(int i = 0; i < 9; i += 1){
            if(board[i][x] == c && i != y) return false;
            if(board[y][i] == c && i != x) return false;
        }
        int oy = (y / 3) * 3;
        int ox = (x / 3) * 3;
        for(int i = 0; i < 3; i += 1){
            for(int j = 0; j < 3; j += 1){
                if(board[oy+i][ox+j] == c && !(oy + i == y && ox + j == x)) return false;
            }
        }
        return true;
     }
    bool dfs(vector<vector<char>>& board){
        for(int i = 0; i < 9; i += 1){
            for(int j = 0; j < 9; j += 1){
                if(board[i][j] == '.'){
                    for(int k = 0; k < 9; k += 1){
                        board[i][j] = '1' + k;
                        if(isValid(board, i, j)){
                            if(dfs(board)){
                                return true;
                            }
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
public:
    void solveSudoku(vector<vector<char>>& board) {
        dfs(board);
    }
};