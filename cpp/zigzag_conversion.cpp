class Solution {
public:
    string convert(string s, int numRows) {
        vector<string> g;
        for(int i = 0; i < numRows; i += 1){
            g.push_back("");
        }
		if(numRows == 1){
			return s;
		}
        int d = 0;
        int inc = 1;
        int n = s.size();
        for(int i = 0; i < n; i += 1){
            g[d].push_back(s[i]);
            if(d == 0){
                inc = 1;
            }else if(d == numRows - 1){
                inc = -1;
            }
            d = d + inc;
        }
        string res = "";
        for(int i = 0; i < numRows; i += 1){
            res = res.append(g[i]);
        }
        return res;
    }
};