/**
 * Created by Administrator on 2015/3/17.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] r1 = version1.split("\\.");
        String[] r2 = version2.split("\\.");
        int r1n = r1.length;
        int r2n = r2.length;
        if(r1n == 0){
            r1 = new String[]{version1};
            r1n = 1;
        }
        if(r2n == 0){
            r2 = new String[]{version2};
            r2n = 1;
        }
        int i = 0;
        while(i < r1n && i < r2n){
            int v1 = Integer.parseInt(r1[i]);
            int v2 = Integer.parseInt(r2[i]);
            if(v1 > v2){
                return 1;
            }else if(v1 < v2){
                return -1;
            }
            i += 1;
        }
        if(r1n == r2n){
            return 0;
        }
        if(r1n > r2n){
            while(i < r1n){
                if(Integer.parseInt(r1[i]) != 0){
                    return 1;
                }
                i += 1;
            }
        }else{
            while(i < r2n){
                if(Integer.parseInt(r2[i]) != 0){
                    return -1;
                }
                i += 1;
            }
        }
        return 0;
    }
    public static void test(){
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion("01","0"));
    }
}
