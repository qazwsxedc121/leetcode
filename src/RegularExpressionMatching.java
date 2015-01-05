import java.util.ArrayList;

/**
 * User: guoxc
 * Date: 15-1-4
 * Time: 3:02
 */

//Using NFA

class ParseItem{
    public char val;
    public boolean is_star;
    public int char_input(char c){
        //char input
        if(is_star){
            if(val == '.' || val == c){
                return 2;//pass(stay) 1->0
            }else{
                return 0;//not pass
            }
        }else if(val == '.' || val == c) {
            return 1;//pass 0->1
        }else{
            return 0;//not pass 0->0
        }
    }
}
class NFA{
    ParseItem[] nodes;
    boolean[] states;
    public NFA(ArrayList<ParseItem> pl){
        nodes = pl.toArray(new ParseItem[pl.size()]);
        states = new boolean[nodes.length+1];
        states[0] = true;
    }
    public void expand(){
        //input an empty char in NFA
        for(int i = 0; i < states.length - 1; i += 1){
            if(states[i] && nodes[i].is_star){
                states[i+1] = true;
            }
        }
    }
    public void statePrint(){
        //debug func
        String res = "";
        for(int i = 0; i < states.length - 1; i += 1){
            if(states[i]){
                res += "1";
            }else{
                res += "0";
            }
            res += "["+ nodes[i].val;
            if(nodes[i].is_star) res += "*";
            res += "]";
        }
        res += states[states.length - 1];
        System.out.println(res);
    }
    public void gostep(char c){
        // input a character into NFA
        if(states[states.length - 1]){
            states[states.length - 1] = false;
        }
        boolean[] newStates = new boolean[states.length];
        for(int i = 0; i < nodes.length ; i += 1){
            if(states[i]){
                int v_input = nodes[i].char_input(c);
                if(v_input == 0){
                    newStates[i] |= false;
                    newStates[i+1] |= false;
                }else if(v_input == 1){
                    newStates[i] |= false;
                    newStates[i+1] |= true;
                }else if(v_input == 2){
                    newStates[i] |= true;
                }
            }
        }
        states = newStates;
//        System.out.println(c);
//        statePrint();
        expand();
//        statePrint();
    }
}
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p){
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        ArrayList<ParseItem> pl = new ArrayList<ParseItem>();
        for(int i = 0; i < parr.length; i += 1){
            if(parr[i] != '*'){
                ParseItem pi = new ParseItem();
                pi.val = parr[i];
                pi.is_star = false;
                pl.add(pi);
            }else{
                pl.get(pl.size() - 1).is_star = true;
            }
        }
        NFA n = new NFA(pl);
        n.expand();
        for(int i = 0; i < sarr.length; i += 1){
            n.gostep(sarr[i]);
        }


        return n.states[n.states.length - 1];
    }
    public static void test(){
        System.out.println(new RegularExpressionMatching().isMatch("aa", "aa"));
        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "a"));
        System.out.println(new RegularExpressionMatching().isMatch("cbaacacaaccbaabcb", "c*b*b*.*ac*.*bc*a*"));
        System.out.println(new RegularExpressionMatching().isMatch("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*"));
    }
}
