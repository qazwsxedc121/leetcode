import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/3/20.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> res = new ArrayList<String>();
        if(n <= 10) return res;
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
        boolean[] bitmap = new boolean[n-9];
        for(int i = 0; i < n - 9; i += 1){
            int b = DNAEncode(s.substring(i,i+10));
            if(m.containsKey(b)){
                m.put(b,m.get(b)+1);
            }else{
                m.put(b,1);
            }
        }
        for(Integer x : m.keySet()){
            if(m.get(x) > 1){
                res.add(DNADecode(x));
            }
        }
        return res;
    }
    private int DNAEncode(String s){
        int res = 0;
        for(int i = 0; i < 10; i += 1){
            char c = s.charAt(i);
            switch (c){
                case 'A':
                    res |= 0;
                    break;
                case 'C':
                    res |= 1;
                    break;
                case 'G':
                    res |= 2;
                    break;
                case 'T':
                    res |= 3;
                    break;
                default:
                    break;
            }
            res = res << 2;
        }
        return res >> 2;
    }
    private String DNADecode(int k){
        String res = "";
        for(int i = 0; i < 10; i += 1){
            int c = k & 3;
            switch (c){
                case 0:
                    res = "A" + res;
                    break;
                case 1:
                    res = "C" + res;
                    break;
                case 2:
                    res = "G" + res;
                    break;
                case 3:
                    res = "T" + res;
                    break;
                default:
                    break;
            }
            k = k >> 2;
        }
        return res;
    }
    public static void test(){
        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.DNAEncode("GAGAGAGAGA"));
        System.out.println(r.DNADecode(r.DNAEncode("GAGAGAGAGA")));
        System.out.println(r.findRepeatedDnaSequences("CAAAAAAAAAC"));
    }
}
