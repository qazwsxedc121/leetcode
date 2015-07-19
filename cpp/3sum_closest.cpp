class Solution {
private:
    int abs(int a){
        return a < 0 ? -a : a;
    }
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());

        int n = nums.size();
        if(n < 3) return 0;
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n - 2; i += 1){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    j += 1;
                }else{
                    k -= 1;
                }
                if(abs(sum - target) < abs(closest - target)){
                    closest = sum;
                }
            }
        }
        return closest;
    }
};
