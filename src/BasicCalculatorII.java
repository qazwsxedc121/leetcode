/**
 * User: guoxc
 * Date: 15-6-22
 * Time: 18:17
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        StringBuilder ns = new StringBuilder();
        for(int i = 0; i < s.length(); i += 1){
            if(s.charAt(i) != ' '){
                ns.append(s.charAt(i));
            }
        }
        ns.append("+");
        String ns2 = ns.toString();
        int[] token = new int[3];
        int res = 0;
        int res2 = 0;
        int oplast = 0;
        int oplast2 = 0;
        while (token[2] != ns2.length()){
            token = read(ns2, token[2]);
            if(token[0] == 0){
                if(token[1] == 0 || token[1] == 1){
                    if(oplast == 0){
                        res = res + res2;
                    }else{
                        res = res - res2;
                    }
                    oplast = token[1];
                    oplast2 = 0;
                }else{
                    oplast2 = token[1];
                }
            }else{
                if(oplast2 == 0){
                    res2 = token[1];
                }else if(oplast2 == 2){
                    res2 = res2 * token[1];
                }else if(oplast2 == 3){
                    res2 = res2 / token[1];
                }
            }
        }
        return res;
    }
    public int[] read(String s, int from){
        int[] res = new int[3];
        char c = s.charAt(from);
        res[2] = from + 1;
        if(c == '+'){
            res[1] = 0;
            return res;
        }else if(c == '-'){
            res[1] = 1;
            return res;
        }else if(c == '*'){
            res[1] = 2;
            return res;
        }else if(c == '/'){
            res[1] = 3;
            return res;
        }
        res[0] = 1;
        while(c <= '9' && c >= '0'){
            res[1] = res[1] * 10 + (c - '0');
            c = s.charAt(res[2]);
            res[2] += 1;
        }
        res[2] -= 1;
        return res;
    }
    public static void test(){
        BasicCalculatorII b = new BasicCalculatorII();
        System.out.println(b.calculate("1+3/2"));
    }
}
