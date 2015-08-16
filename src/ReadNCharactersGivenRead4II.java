/**
 * User: guoxc
 * Date: 15-8-16
 * Time: 21:40
 */
public class ReadNCharactersGivenRead4II {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */


        private int read4(char[] buf){
            return 0;
        }
        private char[] buf_s;
        private int buf_p;
        private int last_r;
        public ReadNCharactersGivenRead4II(){
            buf_s = new char[4];
            buf_p = 0;
            last_r = 0;
        }
        public int read(char[] buf, int n) {
            int i = 0;
            int res = 0;
            for(int j = 0; j < last_r - buf_p && j < n; j += 1){
                buf[j] = buf_s[buf_p + j];
                res += 1;
                i += 1;
            }
            if(i == n){
                buf_p += res;
                return res;
            }
            int old_i = i;
            while(i < n){
                int r = read4(buf_s);
                last_r = r;
                buf_p = 0;
                for(int j = 0; j < r && i + j < n; j += 1){
                    buf[i + j] = buf_s[j];
                    res += 1;
                    buf_p += 1;
                }
                i += r;
                if(old_i == i){
                    break;
                }else{
                    old_i = i;
                }
            }
            return res;
        }

}
