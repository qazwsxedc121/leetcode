/**
 * User: guoxc
 * Date: 15-5-20
 * Time: 19:14
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        else if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0],nums[1]);
        int[][] maxRobbed = new int[2][n];
        maxRobbed[0][0] = 0;
        maxRobbed[0][1] = nums[1];
        maxRobbed[1][0] = nums[0];
        maxRobbed[1][1] = nums[0];
        for(int i = 2; i < n - 1; i += 1){
            maxRobbed[0][i] = Math.max(maxRobbed[0][i-1], maxRobbed[0][i-2]+nums[i]);
            maxRobbed[1][i] = Math.max(maxRobbed[1][i-1], maxRobbed[1][i-2]+nums[i]);
        }
        int max0;
        int max1;

        if(n == 3){
            max0 = Math.max(nums[2], nums[1]);
            max1 = nums[0];
            return Math.max(max0, max1);
        }
        max0 = Math.max(maxRobbed[0][n-3]+nums[n-1], maxRobbed[0][n-2]);
        max1 = maxRobbed[1][n-2];
        return Math.max(max0, max1);

    }
}
