/**
 * User: guoxc
 * Date: 15-8-21
 * Time: 23:06
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] res = new int[2];
        int l = 0;
        int r = n - 1;
        while(l < r){
            int p = numbers[l] + numbers[r];
            if(p == target){
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }else if(p < target){
                l += 1;
            }else if(p > target){
                r -= 1;
            }
        }
        return res;
    }
}
