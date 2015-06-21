class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> m;
        int n = nums.size();
        for(int i = 0; i < n; i += 1){
            m[nums[i]] = i;
        }
        vector<int> res;
        res.push_back(0);
        res.push_back(0);
        for(int i = 0; i < n; i += 1){
            int a = nums[i];
            int b = target - a;
            if(m.find(b) != m.end() && m[b] != i){
                res[0] = i + 1;
                res[1] = m[b] + 1;
                return res;
            }
        }
    }
};