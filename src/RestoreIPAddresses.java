import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-20
 * Time: 22:14
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        return restorePartIpAddress(s,4);
    }
    private List<String> restorePartIpAddress(String s, int partLeft){
        int n = s.length();
        if((n > 0 && partLeft == 0) || n == 0){
            return new ArrayList<String>();
        }else if(partLeft == 1){
            List<String> res = new ArrayList<String>();
            if(validPart(s)) {
                res.add(s);
            }
            return res;
        }else{
            List<String> res = new ArrayList<String>();
            String cut = s.substring(0,1);
            if(validPart(cut)){
                List<String> rest1 = restorePartIpAddress(s.substring(1), partLeft - 1);
                if(!rest1.isEmpty()){
                    for(String si : rest1){
                        res.add(cut + "." + si);
                    }
                }
            }
            if(n == 1)return res;
            cut = s.substring(0,2);
            if(validPart(cut)){
                List<String> rest2 = restorePartIpAddress(s.substring(2), partLeft - 1);
                if(!rest2.isEmpty()){
                    for(String si : rest2){
                        res.add(cut + "." + si);
                    }
                }
            }
            if(n == 2)return res;
            cut = s.substring(0,3);
            if(validPart(cut)){
                List<String> rest3 = restorePartIpAddress(s.substring(3), partLeft - 1);
                if(!rest3.isEmpty()){
                    for(String si : rest3){
                        res.add(cut + "." + si);
                    }
                }
            }
            return res;
        }
    }
    private boolean validPart(String s){
        if(s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }else if(s.length() > 3 || s.length() == 0){
            return false;
        }
        int x = Integer.parseInt(s);
        return x < 256;
    }
    public static void test(){
        RestoreIPAddresses r = new RestoreIPAddresses();
        System.out.println(r.restoreIpAddresses("25525511135"));
        System.out.println(r.restoreIpAddresses("0000"));
        System.out.println(r.restoreIpAddresses("0279245587303"));
    }
}
