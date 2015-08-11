class Solution {
public:
    string next(string s){
        int c = 0;
        int i = 0;
        int n = s.length();
        stringstream ss;
        while(i < n){
            c = i;
            while(i < n - 1 && s[i] == s[i+1]){
                i += 1;
            }
            ss << (i - c + 1) << s[i];
            i += 1;
        }
        return ss.str();
    }
    string countAndSay(int n) {
        string s("1");
        for(int i = 1; i < n; i +=1){
            s = next(s);
        }
        return s;
    }
};
