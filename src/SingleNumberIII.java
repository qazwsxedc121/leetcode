/**
 * User: guoxc
 * Date: 15-8-17
 * Time: 21:13
 */

public class SingleNumberIII {
        public int[] singleNumber(int[] nums) {
            int n = nums.length;
            int nk = 0;
            for(int i = 0; i < n; i += 1){
                nk ^= nums[i];
            }
            nk &= -nk;
            int[] res = new int[2];
            for(int i = 0; i < n; i += 1){
                if((nums[i] & nk) == 0){
                    res[0] ^= nums[i];
                }else{
                    res[1] ^= nums[i];
                }
            }
            return res;
        }

}
