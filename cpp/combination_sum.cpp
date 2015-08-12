class Solution {
private:
    vector<vector<int>> comb(vector<int>& nums, int target, int start){
        vector<vector<int>> res;
        if(start == nums.size() || target < nums[start]) return res;
        if(target == nums[start]){
            vector<int> a;
            a.push_back(target);
            res.push_back(a);
            return res;
        }else{

                vector<vector<int>> res0 = comb(nums, target - nums[start], start);
                for(int i = 0; i < res0.size(); i += 1){
                    vector<int> toa;
                    toa.push_back(nums[start]);
                    for(int j = 0; j < res0[i].size(); j += 1){
                        toa.push_back(res0[i][j]);
                    }
                    res.push_back(toa);
                }
                vector<vector<int>> res1 = comb(nums, target, start + 1);
                for(int i = 0; i < res1.size(); i += 1){
                    res.push_back(res1[i]);
                }
                return res;

        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        return comb(candidates, target, 0);
    }
};
