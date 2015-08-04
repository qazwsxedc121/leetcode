class Solution {
private:
    long div(long a, long b){
        long c = b;
        long res = 0;
        while(a - b >= 0){
            long i = 1;
            c = b;
            while(a - c >= 0){
                c = c << 1;
                i = i << 1;
            }
            res += i >> 1;
            a -= c >> 1;
        }
        return res;
    }
public:
    int divide(int dividend, int divisor) {
        if(divisor == 0) return INT_MAX;
        if(dividend == 0) return 0;
        if(dividend == INT_MIN && divisor == -1 ) return INT_MAX;
        if(dividend < 0 && divisor < 0) return (int)div(-(long)dividend, -(long)divisor);
        else if(dividend < 0 && divisor > 0) return (int)-div(-(long)dividend, (long)divisor);
        else if(dividend > 0 && divisor < 0) return (int)-div((long)dividend, -(long)divisor);
        else return (int)div((long)dividend, (long)divisor);
    }
};
