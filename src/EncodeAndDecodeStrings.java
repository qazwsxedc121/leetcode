import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 */
public class EncodeAndDecodeStrings {

        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            if(strs.size() == 0) sb.append('$');
            for(String istr: strs){
                char[] sc = istr.toCharArray();
                for(int i = 0; i < sc.length; i += 1){
                    if(sc[i] == '|'){
                        sb.append('/');
                    }else if(sc[i] == '/' || sc[i] == '$'){
                        sb.append('/');
                    }
                    sb.append(sc[i]);
                }
                sb.append('|');
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<String>();
            char[] sc = s.toCharArray();
            int n = sc.length;
            if(s.equals("$")) return res;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i += 1){
                if(sc[i] == '|'){
                    res.add(sb.toString());
                    sb = new StringBuilder();
                    continue;
                }
                if(sc[i] == '/' && i < n - 1){
                    if(sc[i+1] == '/' || sc[i+1] == '|' || sc[i+1] == '$'){
                        i += 1;
                    }
                }
                sb.append(sc[i]);
            }
            return res;
        }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
}
