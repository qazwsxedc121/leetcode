class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n = nums.size();
        if (n == 0) return 0;
        int l = 0;
        int r = n - 1;
        int m = (l + r) / 2;
        int res = 0;
        while(l <= r){
            m = (l + r) / 2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] < target){
                l = m + 1;
                res = 1;
            }else{
                r = m - 1;
                res = 2;
            }
        }
        if(res == 1){
            return m + 1;
        }else if(res == 2){
            return m;
        }
        return m;
    }
};
