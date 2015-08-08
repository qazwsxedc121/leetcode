class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;
        vector<int> res;
        int mid = (l + r) / 2;
        while(l <= r){
            mid = (l + r) / 2;
            if(nums[mid] == target){
                break;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(l > r){
            res.push_back(-1);
            res.push_back(-1);
        }else{
            int lm = mid;
            int rm = mid;
            while(lm >= 0 && nums[lm] == target){
                lm -= 1;
            }
            while(rm <= n - 1 && nums[rm] == target){
                rm += 1;
            }
            res.push_back(lm + 1);
            res.push_back(rm - 1);
        }
        return res;
    }
};
