class Solution {
private:
    void reverse(vector<int>& nums, int l, int r){
        while(l < r){
            swap(nums, l, r);
            l += 1;
            r -= 1;
        }
    }
    void swap(vector<int>& nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int i = n - 1;
        while(i > 0 && nums[i] <= nums[i-1]){
            i -= 1;
        }
        if(i == 0){
            reverse(nums, 0, n - 1);
            return;
        }
        //nums[i - 1] < nums[i] > nums[i+1] > ...
        int min_n = INT_MAX;
        int min_i = -1;
        for(int j = n - 1; j >= i ; j -= 1){
            if(nums[j] < min_n && nums[j] > nums[i-1]){
                min_n = nums[j];
                min_i = j;
            }
        }
        if(min_i != -1){
            swap(nums, min_i, i - 1);
            reverse(nums, i, n - 1);
        }else{
            reverse(nums, i-1, n - 1);
        }
    }
};
