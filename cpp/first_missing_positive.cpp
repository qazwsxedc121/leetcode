class Solution {
private:
    void swap(vector<int>&nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        for(int i = 0; i < n; i += 1){
            if(nums[i] > 0 && nums[i] < n + 1 && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i]-1);
                i -= 1;
            }
        }
        for(int i = 0; i < n; i += 1){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
};
