import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2015/3/6.
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(distanceOne(start, end)) return 2;
        List<String> queue = new ArrayList<String>();
        queue.add(start);
        int c = 1;
        while(!queue.isEmpty()){
            List<String> newQueue = new ArrayList<String>();
            for(String x : queue){
                if(distanceOne(x,end)){
                    return c + 1;
                }
                HashSet<String> temp = new HashSet<String>();
                for(String s : dict){
                    if(distanceOne(x, s)){
                        newQueue.add(s);
                        temp.add(s);
                    }
                }
                dict.removeAll(temp);
            }
            queue = newQueue;
            c += 1;
        }
        return 0;
    }
    private boolean distanceOne(String a, String b){
        if(a.length() != b.length()) return false;
        int c = 0;
        for(int i = 0; i < a.length(); i += 1){
            if(a.charAt(i) != b.charAt(i)){
                c += 1;
            }
        }
        return c == 1;
    }
    public static void test(){
        WordLadder w = new WordLadder();
        Set<String> s = new HashSet<String>();
        String[] sa = new String[]{"hot","dot","dog","lot","log"};
        for(int i = 0; i < sa.length; i += 1){
            s.add(sa[i]);
        }
        System.out.println(w.ladderLength("hit","cog", s));
    }
}
