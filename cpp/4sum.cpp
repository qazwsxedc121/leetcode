class Solution {

public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int last_i = 0;
        for(int i = 0; i < n - 3; i += 1){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target_i = target - nums[i];
            for(int j = i + 1; j < n - 2; j += 1){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int target_j = target_i - nums[j];
                int k = j + 1;
                int l = n - 1;
                while(k < l){
                    if(nums[k] + nums[l] == target_j){
                        vector<int> quadruplet;
                        quadruplet.push_back(nums[i]);
                        quadruplet.push_back(nums[j]);
                        quadruplet.push_back(nums[k]);
                        quadruplet.push_back(nums[l]);
                        if(res.empty() || res[res.size() - 1] != quadruplet){
                            res.push_back(quadruplet);
                        }
                        k += 1;
                        l -= 1;
                    }else if(nums[k] + nums[l] < target_j){
                        k += 1;
                    }else{
                        l -= 1;
                    }
                }
            }
        }
        return res;
    }
};
