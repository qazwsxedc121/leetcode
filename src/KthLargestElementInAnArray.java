/**
 * Created by Administrator on 2015/5/23.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        k -= 1;
        int l = 0;
        int r = nums.length;
        int x = partition(nums, l, r);
        while(x != k){
            if(x < k){
                l = x;
            }else{
                r = x;
            }
            x = partition(nums, l, r);
        }
        return nums[x];
    }
    private int partition(int[] nums, int l, int r){
        if(r - l <= 1) return l;
        int pivot = nums[r-1];
        int lp = l;
        for(int i = l; i < r - 1; i += 1){
            if(nums[i] >= pivot){
                swap(nums, lp, i);
                lp += 1;
            }
        }
        swap(nums, r-1, lp);
        return lp;
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}
