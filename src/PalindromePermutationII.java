import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2015/8/28.
 */
public class PalindromePermutationII {
    HashSet<String> permutations;
    private void swap(char[] s, int l, int r){
        char t = s[l];
        s[l] = s[r];
        s[r] = t;
    }
    private void perm(char[] s, int k){
        if(k == s.length){
            permutations.add(new String(s));
        }else{
            for(int i = k; i < s.length; i += 1){
                swap(s, k, i);
                perm(s, k + 1);
                swap(s, k, i);
            }
        }
    }
    public List<String> generatePalindromes(String s) {
        permutations = new HashSet<String>();
        int[] charm = new int[256];
        int n = s.length();
        List<String> res = new ArrayList<String>();
        if(n == 1){
            res.add(s);
            return res;
        }
        for(int i = 0; i < n; i += 1){
            charm[s.charAt(i)] += 1;
        }
        int oddc = 0;
        int oddi = -1;
        for(int i = 0; i < 256; i += 1){
            if((charm[i] % 2) == 1){
                oddc += 1;
                oddi = i;
            }
        }

        if(oddc > 1) return res;

        if(oddc == 1){
            charm[oddi] -= 1;
            char[] x = new char[(n-1)/2];
            int xi = 0;
            for(int i = 0; i < 256; i += 1){
                while(charm[i] > 0){
                    x[xi] = (char)i;
                    charm[i] -= 2;
                    xi += 1;
                }
            }
            perm(x, 0);
            char c = (char)oddi;
            for(String si : permutations){
                String rev = new StringBuffer(si).reverse().toString();
                res.add(si + c + rev);
            }
        }else{
            char[] x = new char[n/2];
            int xi = 0;
            for(int i = 0; i < 256; i += 1){
                while(charm[i] > 0){
                    x[xi] = (char)i;
                    charm[i] -= 2;
                    xi += 1;
                }
            }
            perm(x, 0);
            for(String si : permutations){
                String rev = new StringBuffer(si).reverse().toString();
                res.add(si + rev);
            }
        }
        return res;
    }
}
