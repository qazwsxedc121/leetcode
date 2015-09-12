import java.util.Arrays;

/**
 * Created by Administrator on 2015/9/12.
 */
public class WiggleSort {
    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 1; i < n - 1; i += 2){
            swap(nums, i, i + 1);
        }
    }
}
