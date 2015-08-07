class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(target == nums[l]) return l;
            if(target == nums[r]) return r;
            if(target == nums[mid]) return mid;
            else if(target < nums[mid]){
                if(nums[l] < nums[r]){
                    r = mid - 1;
                }else if(target < nums[r] && nums[mid] > nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(nums[l] < nums[r]){
                    l = mid + 1;
                }else if(target > nums[l] && nums[mid] < nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
};
