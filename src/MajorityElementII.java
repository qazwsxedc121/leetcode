import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/29.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cd1 = 0;
        int cd2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < n; i += 1){
            if(nums[i] == cd1){
                c1 += 1;
            }else if(nums[i] == cd2){
                c2 += 1;
            }else if(c1 == 0){
                cd1 = nums[i];
                c1 += 1;
            }else if(c2 == 0){
                cd2 = nums[i];
                c2 += 1;
            }else{
                c1 -= 1;
                c2 -= 1;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i = 0; i < n; i += 1){
            if(nums[i] == cd1){
                c1 += 1;
            }else if(nums[i] == cd2){
                c2 += 1;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if(c1 > n / 3){
            res.add(cd1);
        }
        if(c2 > n / 3){
            res.add(cd2);
        }
        return res;
    }

    public static void test(){
        MajorityElementII m = new MajorityElementII();
        System.out.println(m.majorityElement(new int[]{3,4,3}));
    }
}
