import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/1/29.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs){
        int[][] record = new int[strs.length][40];
        for(int i = 0; i < strs.length; i += 1){
            for(int j = 0; j < strs[i].length(); j += 1){
                record[i][strs[i].charAt(j)-'a'] += 1;
            }
        }
        int[] group = new int[strs.length];
        int[] groupStat = new int[strs.length+1];
        int groupCounter = 1;
        for(int i = 0; i < strs.length; i += 1){
            if(group[i] != 0)
                continue;
            group[i] = groupCounter;
            groupStat[groupCounter] += 1;
            for(int j = i + 1; j < strs.length; j += 1){
                boolean eq = true;
                for(int k = 0; k < 40; k += 1){
                    if(record[i][k] != record[j][k]){
                        eq = false;
                        break;
                    }
                }
                if(eq){
                    group[j] = groupCounter;
                    groupStat[groupCounter] += 1;
                }
            }
            groupCounter += 1;
        }
        List<String> res = new ArrayList<>();
        for(int i = 1; i < strs.length; i += 1){
            if(groupStat[i] > 1){
                for(int j = 0; j < strs.length; j += 1){
                    if(group[j] == i){
                        res.add(strs[j]);
                    }
                }
            }
        }
        return res;
    }
    public static void test(){
        Anagrams instance = new Anagrams();
        System.out.println(instance.anagrams(new String[]{"aaa","aaa","","bc","cb"}));
    }
}
