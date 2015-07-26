class Solution {
private:
    vector<string> res;
    void dfs(int left, int right, string s){
        if(left > right){
            return;
        }
        if(left == 0 && right == 0){
            res.push_back(s);
        }
        if(left != 0){
            dfs(left - 1, right, s + "(");
        }
        if(right != 0){
            dfs(left, right - 1, s + ")");
        }
    }
public:
    vector<string> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }
};
