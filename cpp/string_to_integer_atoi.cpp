class Solution {
public:
    int myAtoi(string str) {
        string nosp = "";
        int n = str.length();
        int i = 0;
        while(str[i] == ' '){
            i += 1;
        }
        for(; i < n; i += 1){
            nosp.push_back(str.at(i));
        }
        int sign = 1;
        int p = 0;
        str = nosp;
        if(str.length() == 0) return 0;
        if(str.at(0) == '+'){
            sign = 1;
            p += 1;
        }else if(str.at(0) == '-'){
            sign = -1;
            p += 1;
        }
        long x = 0;
        long res = 0;
        while(p < str.length() && str.at(p) <= '9' && str.at(p) >= '0'){
            res = sign * x;
            if(res > 2147483647l){
                return 0x7fffffff;
            }else if(res < -2147483648l){
                return 0x80000000;
            }
            x = x * 10 + (str.at(p) - '0');
            p += 1;
        }
        res = sign * x;
        if(res > 2147483647l){
            return 0x7fffffff;
        }else if(res < -2147483648l){
            return 0x80000000;
        }
        return res;
    }
};