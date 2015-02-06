/**
 * Created by Administrator on 2015/2/6.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k){
        if(n == 1){
            return "1";
        }else if(n == 2){
            if(k == 1){
                return "12";
            }else{
                return "21";
            }
        }else{
            int section = fact(n-1);
            int first = (k - 1) / section + 1;
            int[] rest = new int[n-1];
            int c = 1;
            for(int i = 0; i < n-1; i += 1){
                if(c == first) {
                    c += 1;
                }
                rest[i] = c;
                c += 1;
            }
            String res = "" + first;
            String restOrder = getPermutation(n-1, ((k - 1) % section) + 1);
            res += translate(restOrder, rest);
            return res;
        }
    }
    private String translate(String permutation, int[] alphabet){
        char[] chars = permutation.toCharArray();
        int[] order = new int[chars.length];
        for(int i = 0; i < order.length; i += 1){
            order[i] = chars[i] - '1';
        }
        int[] resInt = new int[chars.length];
        for(int i = 0; i < chars.length; i += 1){
            resInt[i] = alphabet[order[i]];
        }
        String res = "";
        for(int i = 0; i < chars.length; i += 1){
            res += "" + resInt[i];
        }
        return res;
    }
    private int fact(int n){
        if(n == 1)
            return 1;
        else{
            int res = 1;
            for(int i = 2; i < n+1; i += 1){
                res *= i;
            }
            return res;
        }
    }
    public static void test(){
        PermutationSequence instance = new PermutationSequence();
        System.out.println(instance.getPermutation(5,1));
    }
}
