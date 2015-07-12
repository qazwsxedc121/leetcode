class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int n = strs.size();
        if(n == 0) return "";
        int min_L = strs[0].length();
        int min_i = 0;
        for(int i = 1; i < n; i += 1){
            if(strs[i].length() < min_L){
                min_L = strs[i].length();
                min_i = i;
            }
        }
        int l = 0;
        for(int i = 0; i < strs[min_i].length(); i += 1){
            char c = strs[min_i][i];
            for(int j = 0; j < n; j += 1){
                if(j == min_i) continue;
                if(strs[j][i] != c){
                    return strs[min_i].substr(0, l);
                }
            }
            l += 1;
        }
        return strs[min_i].substr(0, l);
    }
};
