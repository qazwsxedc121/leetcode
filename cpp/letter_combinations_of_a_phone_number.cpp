class Solution {
public:
    vector<string> letterCombinations(string digits) {
        string map_c[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        vector<string> res;
        if(digits.size() == 0) return res;
        res.push_back("");
        int n = digits.size();
        for(int i = 0; i < n; i += 1){
            vector<string> newres;
            int digit = digits[i] - '2';
            int l = map_c[digit].size();
            int rsize = res.size();
            for(int j = 0; j < rsize; j += 1){
                for(int k = 0; k < l; k += 1){
                    newres.push_back(res[j] + map_c[digit].substr(k,1));
                }
            }
            res = newres;
        }
        return res;
    }
};
