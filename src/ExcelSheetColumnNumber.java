/**
 * Created by Administrator on 2015/3/18.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s){
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i += 1){
            res = res * 26 + (s.charAt(i) - 'A') + 1;
        }
        return res;
    }
}
