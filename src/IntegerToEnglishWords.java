import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/21.
 */
public class IntegerToEnglishWords {
    String[] s0_9 = new String[]{ "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] s10_19 = new String[]{ "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};
    String[] s20_90 = new String[]{ "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String s0_99(int num){
        if(num < 10){
            return s0_9[num];
        }else if(num >= 10 && num < 20){
            return s10_19[num - 10];
        }else{
            String res = "";
            int a = num / 10;
            int b = num % 10;
            res = s20_90[a - 2];
            if(b > 0){
                res = res + " " + s0_9[b];
            }
            return res;
        }
    }
    private String s0_999(int num){
        if(num < 100){
            return s0_99(num);
        }
        int a = num / 100;
        int b = num % 100;
        String res = "";
        res = s0_9[a] + " Hundred";
        if(b > 0){
            res = res + " " + s0_99(b);
        }
        return res;
    }
    public String numberToWords(int num) {
        String[] scale = new String[]{"Thousand", "Million", "Billion", "Trillion"};
        if(num < 1000) return s0_999(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(num > 0){
            list.add(num % 1000);
            num = num / 1000;
        }
        String res = "";
        int z = list.get(0);
        if(z != 0){
            res = s0_999(z);
        }
        int n = list.size();
        for(int i = 1; i < n; i += 1){
            z = list.get(i);
            if(z != 0){
                res = s0_999(z) + " " + scale[i-1] + " " + res;
            }
        }
        return res.trim();
    }
}
