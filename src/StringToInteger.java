/**
 * Created by Administrator on 2015/1/2.
 */
public class StringToInteger {
    public int atoi(String str){
        str = str.trim();
        char[] arr = str.toCharArray();
        char[] rec = new char[arr.length];
        int rec_len = 0;
        int neg = 0;
        boolean error = false;
        for(int i = 0; i < arr.length; i += 1){
            if(arr[i] == '-') {
                if (neg == 0) {
                    neg = -1;
                    continue;
                } else if (neg == -1 || neg == 1) {
                    error = true;
                    break;
                }
            }
            if(arr[i] == '+'){
                if (neg == 0){
                    neg = 1;
                    continue;
                }else if(neg == -1 || neg == 1){
                    error = true;
                    break;
                }
            }
            if(arr[i] >=  '0' && arr[i] <= '9'){
                rec[rec_len] = arr[i];
                rec_len += 1;
            }else{
                break;
            }
        }
        if(error){
            return 0;
        }
        Long res = new Long(0);
        for(int i = 0; i < rec_len; i += 1){
            res = res * 10;
            res = res + (rec[i] - '0');
            if(Math.abs(res) > 21474836500l){
                break;
            }
        }
        if(res > new Long(2147483467) && neg != -1){
            res = new Long(2147483647);
        }else if(neg == -1 && res > 2147483648l){
            res = new Long(-2147483648);
        }else if(neg == -1){
            res = -res;
        }
        return res.intValue();
    }
    public static void test(){
        System.out.println(new StringToInteger().atoi("-2147483648"));
        System.out.println(new StringToInteger().atoi("9223372036854775809"));
        System.out.println(new StringToInteger().atoi(" 10522545459"));
    }

}
