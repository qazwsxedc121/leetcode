class Solution {
public:
    int reverse(int x) {
        bool neg = (x < 0);
        long xr = neg ? -(long)x : (long)x;
        long res = 0;
        while(xr != 0){
            long c = xr % 10;
            res = res * 10 + c;
            xr = xr / 10;
        }
        if(res > ((long)1 << 31)){
            return 0;
        }
        if(neg){
            return -res;
        }else{
            return res;
        }
    }
};