import java.util.*;

/**
 * Created by Administrator on 2015/9/2.
 */
public class GroupShiftedStrings {
    private String first(String s){
        if(s.equals("")) return "";
        char[] arr = s.toCharArray();
        int n = arr.length;
        while(arr[0] != 'z'){
            for(int i = 0; i < n; i += 1){
                if(arr[i] == 'z'){
                    arr[i] = 'a';
                }else{
                    arr[i] += 1;
                }
            }
        }
        return new String(arr);
    }
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        int n = strings.length;
        for(int i = 0; i < n; i += 1){
            String f = first(strings[i]);
            if(map.containsKey(f)){
                map.get(f).add(strings[i]);
            }else{
                map.put(f, new ArrayList<String>());
                map.get(f).add(strings[i]);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(String s : map.keySet()){
            Collections.sort(map.get(s));
            res.add(map.get(s));
        }
        return res;
    }
}
