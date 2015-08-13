class Solution {
private:
    vector<vector<int>> comb(vector<int>& nums, int target, int start){
        int n = nums.size();
        vector<vector<int>> res;
        if(start == n || target < nums[start]){
            return res;
        }else if(target == nums[start]){
            vector<int> toadd;
            toadd.push_back(target);
            res.push_back(toadd);
            return res;
        }else{
            vector<vector<int>> res0 = comb(nums, target - nums[start], start + 1);
            for(int i = 0; i < res0.size(); i += 1){
                vector<int> v;
                v.push_back(nums[start]);
                for(int j = 0; j < res0[i].size(); j += 1){
                    v.push_back(res0[i][j]);
                }
                res.push_back(v);
            }
            int tostart = start + 1;
            while(tostart <= n && nums[tostart] == nums[start]){
                tostart += 1;
            }
            vector<vector<int>> res1 = comb(nums, target, tostart);
            for(int i = 0; i < res1.size(); i += 1){
                res.push_back(res1[i]);
            }
            return res;
        }
    }
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        return comb(candidates, target, 0);
    }
};
