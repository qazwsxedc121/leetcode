/**
 * User: guoxc
 * Date: 15-1-20
 * Time: 22:29
 */
public class CountAndSay {
    public String countAndSay(int n){
        if(n == 1) return "1";
        String l = countAndSay(n-1);
        String res = "";
        int i = 0;
        while(i < l.length()){
            int c = 0;
            char ci = l.charAt(i);
            while(i < l.length() && l.charAt(i) == ci){
                i += 1;
                c += 1;
            }
            res += c + "" + (ci - '0');

        }
        return res;


    }
    public static void test(){
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(5));
    }
}
