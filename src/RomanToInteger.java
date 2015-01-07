/**
 * User: guoxc
 * Date: 15-1-7
 * Time: 17:12
 */
public class RomanToInteger {
    public int romanToInt(String s){
        int res = 0;
        char[] sarr = s.toCharArray();
        int i = 0;
        while(i < sarr.length){
            switch(sarr[i]){
                case 'M':
                    res += 1000;
                    i += 1;
                    break;
                case 'C':
                    if(i+1 < sarr.length && sarr[i+1] == 'M'){
                        res += 900;
                        i += 2;
                    }else if(i+1 < sarr.length && sarr[i+1] == 'D'){
                        res += 400;
                        i += 2;
                    }else{
                        res += 100;
                        i += 1;
                    }
                    break;
                case 'D':
                    res += 500;
                    i += 1;
                    break;
                case 'X':
                    if(i+1 < sarr.length && sarr[i+1] == 'C'){
                        res += 90;
                        i += 2;
                    }else if(i+1 < sarr.length && sarr[i+1] == 'L'){
                        res += 40;
                        i += 2;
                    }else{
                        res += 10;
                        i += 1;
                    }
                    break;
                case 'L':
                    res += 50;
                    i += 1;
                    break;
                case 'I':
                    if(i+1 < sarr.length && sarr[i+1] == 'X'){
                        res += 9;
                        i += 2;
                    }else if(i+1 < sarr.length && sarr[i+1] == 'V'){
                        res += 4;
                        i += 2;
                    }else{
                        res += 1;
                        i += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    i += 1;
                    break;
            }
        }
        return res;
    }
    public static void test(){
        System.out.println(new RomanToInteger().romanToInt("CDXXI"));
    }
}
