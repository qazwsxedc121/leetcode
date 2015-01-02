/**
 * Created by Administrator on 2015/1/2.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows){
        char[] arr = s.toCharArray();
        char[] res = new char[s.length()];
        int c = 0;
        int r = nRows * 2 - 2;
        if(r == 0){
            r = 1;
        }
        for(int i = 0; i < nRows; i += 1){
            for(int j = i; j < arr.length; j += r){
                res[c] = arr[j];
                c += 1;
                int next = j + 2 * (nRows - 1 - i);
                if(i != 0 && i != nRows - 1 && next < arr.length){
                    res[c] = arr[next];
                    c += 1;
                }
            }
        }
        return String.valueOf(res);
    }
    public static void test(){
//        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZagConversion().convert("P", 1));
    }
}
