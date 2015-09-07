/**
 * Created by Administrator on 2015/9/7.
 */
public class StrobogrammaticNumber {
    private int getStroboDigit(int a){
        switch(a){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return -1; // 2 reverse not 5
            case 5:
                return -1; // 5 reverse not 2
            case 6:
                return 9;
            case 8:
                return 8;
            case 9:
                return 6;
            default:
                return -1;
        }
    }
    public boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;
        while(l < r){
            int a = num.charAt(l) - '0';
            int b = num.charAt(r) - '0';
            if(getStroboDigit(a) == b){
                l += 1;
                r -= 1;
            }else{
                return false;
            }
        }
        if(l == r){
            return getStroboDigit(num.charAt(l) - '0') == num.charAt(l) - '0';
        }else{
            return true;
        }
    }
}
