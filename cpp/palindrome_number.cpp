class Solution {
public:
    bool isPalindrome(int x) {
        int r = 0;
        if(x < 0) return false;
        if(x < 10) return true;
        int xc = x;
        while(x > 0){
            r = r * 10 + (x % 10);
            x = x / 10;
        }
        return xc == r;
    }
};