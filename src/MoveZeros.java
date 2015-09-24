
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 0) return;
        int k = 0;
        for(int i = 0; i < n; i += 1){
            if(nums[i] != 0){
                nums[k] = nums[i];
                k += 1;
            }
        }
        while(k < n){
            nums[k] = 0;
            k += 1;
        }
        return;
    }
}
