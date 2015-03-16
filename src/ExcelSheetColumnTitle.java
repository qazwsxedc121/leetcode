/**
 * Created by Administrator on 2015/3/17.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String res = "";
        while(n > 0){
            n = n - 1;
            int k =n % 26;
            res = (char)('A' + k) + res;
            n = n / 26;
        }
        return res;
    }
    public static void test(){
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        System.out.println(e.convertToTitle(1));
        System.out.println(e.convertToTitle(26));
        System.out.println(e.convertToTitle(27));
    }
}
