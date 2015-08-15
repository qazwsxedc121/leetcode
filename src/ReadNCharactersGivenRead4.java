/**
 * User: guoxc
 * Date: 15-8-15
 * Time: 10:18
 */
public class ReadNCharactersGivenRead4 {
    public int read4(char[] buf){
        return 0;
    }
    public int read(char[] buf, int n) {
        if(n <= 0) return 0;
        char[] buffer = new char[4];
        int i = 0;
        int res = 0;
        int rn = -1;
        while(i < n && rn != 0){
            rn = read4(buffer);
            for(int j = 0; j < rn && i + j < n; j += 1){
                buf[i+j] = buffer[j];
                res += 1;
            }
            i += rn;
        }
        return res;
    }
}
