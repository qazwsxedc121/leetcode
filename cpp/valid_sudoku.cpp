class Solution {
private:
    bool isValidLine(vector<char> line){
        int m[9] = {0};
        for(int i = 0; i < line.size(); i += 1){
            if(line[i] == '.') continue;
            else if(m[line[i] - '0'] == 1) return false;
            else m[line[i] - '0'] = 1;
        }
        return true;
    }
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i = 0; i < 9; i += 1){
            vector<char> xs;
            vector<char> ys;
            vector<char> zs;
            for(int j = 0; j < 9; j += 1){
                xs.push_back(board[i][j]);
                ys.push_back(board[j][i]);
                zs.push_back(board[(i % 3) * 3 + (j % 3)][(i / 3) * 3 + (j / 3)]);
            }
            if(!isValidLine(xs)) return false;
            if(!isValidLine(ys)) return false;
            if(!isValidLine(zs)) return false;
        }
        return true;
    }
};
