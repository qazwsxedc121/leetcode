/**
 * Created by Administrator on 2015/2/9.
 */
public class AddBinary {
    public String addBinary(String a, String b){
        boolean carry = false;
        String res = "";
        int pi = a.length() - 1;
        int pj = b.length() - 1;
        while(pi > -1 && pj > -1){
            boolean ai = a.charAt(pi) == '1';
            boolean bi = b.charAt(pj) == '1';
            if(carry){
                if(ai && bi){// 3
                    carry = true;
                    res = "1" + res;
                }else if(ai || bi){// 2
                    carry = true;
                    res = "0" + res;
                }else{// 1
                    carry = false;
                    res = "1" + res;
                }
            }else{
                if(ai && bi){//2
                    carry = true;
                    res = "0" + res;
                }else if(ai || bi){
                    carry = false;
                    res = "1" + res;
                }else{
                    carry = false;
                    res = "0" + res;
                }
            }
            pi -= 1;
            pj -= 1;
        }
        if(pi > -1){
            while(pi > -1){
                boolean ai = a.charAt(pi) == '1';
                if(carry && ai){//2
                    carry = true;
                    res = "0" + res;
                }else if(carry || ai){//1
                    carry = false;
                    res = "1" + res;
                }else{//0
                    carry = false;
                    res = "0" + res;
                }
                pi -= 1;
            }
        }else if(pj > -1){
            while(pj > -1){
                boolean bj = b.charAt(pj) == '1';
                if(carry && bj){//2
                    carry = true;
                    res = "0" + res;
                }else if(carry || bj){//1
                    carry = false;
                    res = "1" + res;
                }else{//0
                    carry = false;
                    res = "0" + res;
                }
                pj -= 1;
            }
        }
        if(carry){
            res = "1" + res;
        }
        return res;
    }
    public static void test(){
        AddBinary instance = new AddBinary();
        System.out.println(instance.addBinary("11","11"));
        System.out.println(instance.addBinary("110100","101010"));
    }
}
