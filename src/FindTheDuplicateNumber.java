/**
 * Created by Administrator on 2015/9/28.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = n;
        int mid = 0;
        while(l < r){
            mid = (l + r) / 2;
            int count = 0;
            for(int i = 0; i < n; i += 1){
                if(nums[i] <= mid){
                    count += 1;
                }
            }
            if(count <= mid){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}
