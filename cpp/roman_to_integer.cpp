class Solution {
public:
    int romanToInt(string s) {
        int res = 0;
        int n = s.size();
        int i = 0;
        while(i < n){
            switch(s[i]){
                case 'M':
                    res += 1000;
                    i += 1;
                    break;
                case 'D':
                    res += 500;
                    i += 1;
                    break;
                case 'C':
                    if(i < n - 1 && s[i + 1] == 'M'){
                        res += 900;
                        i += 2;
                    }else if(i < n - 1 && s[i + 1] == 'D'){
                        res += 400;
                        i += 2;
                    }else{
                        res += 100;
                        i += 1;
                    }
                    break;
                case 'L':
                    res += 50;
                    i += 1;
                    break;
                case 'X':
                    if(i < n - 1 && s[i + 1] == 'C'){
                        res += 90;
                        i += 2;
                    }else if(i < n - 1 && s[i + 1] == 'L'){
                        res += 40;
                        i += 2;
                    }else{
                        res += 10;
                        i += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    i += 1;
                    break;
                case 'I':
                    if(i < n - 1 && s[i + 1] == 'X'){
                        res += 9;
                        i += 2;
                    }else if(i < n - 1 && s[i + 1] == 'V'){
                        res += 4;
                        i += 2;
                    }else{
                        res += 1;
                        i += 1;
                    }
                    break;
            }
        }
        return res;
    }
};
