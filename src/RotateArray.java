/**
 * Created by Administrator on 2015/3/22.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return;
        k = k % n;
        if(k == 0) return;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    private void reverse(int[] nums, int l, int r){
        if(l >= r) return;
        while(l < r){
            swap(nums,l,r);
            l += 1;
            r -= 1;
        }
    }
    private void swap(int[] nums, int l, int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
    public void rotateNaive(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return;
        k = k % n;
        int[] res = new int[n];
        for(int i = 0; i < k; i += 1){
            res[i] = nums[n-k+i];
        }
        for(int i = k; i < n; i += 1){
            res[i] = nums[i-k];
        }
        for(int i = 0; i < n; i += 1){
            nums[i] = res[i];
        }
    }
}
