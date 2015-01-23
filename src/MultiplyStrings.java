/**
 * User: guoxc
 * Date: 15-1-23
 * Time: 19:03
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2){
        String res = "0";
        int l1 = num1.length();
        int l2 = num2.length();
        if(l1 < l2){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        l1 = num1.length();
        l2 = num2.length();
        // l1 > l2
        int j = 0;
        for(int i = l2 - 1; i > -1; i -= 1){
            int c = num2.charAt(i) - '0';
            String dr = multiplyByDigit(num1, c);
            for(int k = 0; k < j; k += 1){
                dr = dr + "0";
            }
            j += 1;
            res = add(dr, res);
        }
        return shrink(res);
    }
    public String multiplyByDigit(String num1, int num2){
        int carry = 0;
        String res = "";
        for(int i = num1.length() - 1; i > -1; i -= 1){
            int c = num1.charAt(i) - '0';
            int d = (c * num2 + carry) % 10;
            carry = (c * num2 + carry) / 10;
            res = (d+"") + res;
        }
        if(carry > 0){
            res = (carry+"") + res;
        }
        return res;
    }
    public String add(String num1, String num2){
        int l1 = num1.length();
        int l2 = num2.length();
        if(l1 > l2){
            for(int i = 0; i < l1 - l2; i += 1){
                num2 = "0" + num2;
            }
        }else{
            for(int i = 0; i < l2 - l1; i += 1){
                num1 = "0" + num1;
            }
        }
        String res = "";
        int l = num1.length();
        int carry = 0;
        for(int i = l - 1; i > -1; i -= 1){
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(i) - '0';
            int d = (c1 + c2 + carry) % 10;
            carry = (c1 + c2 + carry) / 10;
            res = (d+"") + res;
        }
        if(carry == 1){
            res = "1" + res;
        }
        return res;
    }
    public String shrink(String num1){
        int i = 0;
        while(i < num1.length() && num1.charAt(i) == '0'){
            i += 1;
        }
        if(i == num1.length()){
            return "0";
        }
        return num1.substring(i);
    }
    public static void test(){
        MultiplyStrings instance = new MultiplyStrings();
        System.out.println(instance.multiply("11111111","11111111"));
        System.out.println(instance.multiply("11111111","0"));
    }
}
