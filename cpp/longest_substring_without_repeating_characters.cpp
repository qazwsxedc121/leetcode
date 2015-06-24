class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        bool charMap[256] = {false};
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int l = 0;
        int r = -1;
        int res = 0;
        while(r < n - 1){
            r += 1;
            char c = s.at(r);
            if(charMap[c]){
                while(s.at(l) != c){
                    charMap[s.at(l)] = false;
                    l += 1;
                }
                l += 1;
            }else{
                charMap[c] = true;
                if(r - l + 1 > res){
                    res = r - l + 1;
                }
            }
        }
        return res;
    }
};
