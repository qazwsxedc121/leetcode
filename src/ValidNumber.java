/**
 * Created by Administrator on 2015/2/7.
 */
public class ValidNumber {
    public boolean isNumber(String s){
        s = s.trim();
        char[] sarr = s.toCharArray();
        if(s.length() == 0) return false;
        if(sarr[0] == '-' || sarr[0] == '+'){
            return isNumberC1(sarr, 1);
        }else
            return isNumberC1(sarr, 0);
    }
    private boolean isNumberC1(char[] arr, int start){
        // state 1
        int i = start;
        boolean hasNum = false;
        boolean hasDot = false;
        while(i < arr.length){
            if(arr[i] <= '9' && arr[i] >= '0'){
                i += 1;
                hasNum = true;
                continue;
            }else if(arr[i] == '.'){
                if(hasDot){
                    return false;
                }else {
                    hasDot = true;
                }
                i += 1;
                continue;
            }else if(arr[i] == 'e' || arr[i] == 'E'){
                if(hasNum)
                    return isNumberC2(arr, i + 1);
                else
                    return false;
            }else{
                return false;
            }
        }
        return hasNum;
    }
    private boolean isNumberC2(char[] arr, int start){
        //state 3
        int i = start;
        if(start == arr.length) return false;
        boolean hasNum = false;
        if(arr[i] == '+' || arr[i] == '-'){
            i += 1;
        }
        while(i < arr.length){
            if(arr[i] <= '9' && arr[i] >= '0'){
                i += 1;
                hasNum = true;
                continue;
            }else{
                return false;
            }
        }
        return hasNum;
    }
    public static void test(){
        ValidNumber instance = new ValidNumber();
        System.out.println(instance.isNumber(" 0.1 "));
        System.out.println(instance.isNumber(" -3e10 "));
        System.out.println(!instance.isNumber(" 1 a"));
        System.out.println(!instance.isNumber("abc "));
        System.out.println(!instance.isNumber(" 0.1.87"));
        System.out.println(instance.isNumber(" -0.1 "));
        System.out.println(instance.isNumber("+0.1 "));
        System.out.println(!instance.isNumber(" .e"));
        System.out.println(instance.isNumber("122"));
        System.out.println(!instance.isNumber(" "));
        System.out.println(!instance.isNumber(" 1e. "));
        System.out.println(instance.isNumber(" .1 "));
        System.out.println(instance.isNumber(" 2. "));
        System.out.println(!instance.isNumber(" . "));
        System.out.println(instance.isNumber(" 234234e+23 "));
        System.out.println(!instance.isNumber("0e"));




    }
}
