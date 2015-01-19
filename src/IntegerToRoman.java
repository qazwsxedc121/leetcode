import java.util.ArrayList;

/**
 * User: guoxc
 * Date: 15-1-6
 * Time: 18:11
 */
public class IntegerToRoman {
    public String intToRoman(int num){
        String res = "";
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(num > 0){
            digits.add(num % 10);
            num = num / 10;
        }
        for(int i = 0; i < digits.size(); i += 1){
             res = digitToString(i, digits.get(i)) + res;
        }
        return res;
    }
    public String digitToString(int n, int d){
        String result = "";
        String r1 = "I";
        String r5 = "V";
        String r10 = "X";
        switch (n){
            case 0:
                break;
            case 1:
                r1 = "X";
                r5 = "L";
                r10 = "C";
                break;
            case 2:
                r1 = "C";
                r5 = "D";
                r10 = "M";
                break;
            case 3:
                r1 = "M";
                break;
            default:
                break;
        }
        if(d >= 0 && d <= 3){
            for(int j = 0; j < d; j += 1){
                result += r1;
            }
        }else if(d == 4){
            result = r1 + r5;
        }else if(d >= 5 && d <= 8){
            result = r5;
            for(int j = 5; j < d; j += 1){
                result += r1;
            }
        }else if(d == 9){
            result = r1 + r10;
        }else if(d == 0){

        }
        return result;
    }
    public static void test(){
        System.out.println(new IntegerToRoman().intToRoman(13));
        System.out.println(new IntegerToRoman().intToRoman(1682));
    }
}
