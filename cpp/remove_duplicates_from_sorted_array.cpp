class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        if(n <= 1) return n;
        int i = 0;
        int j = 1;
        while(j < n){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i += 1;
            }
            j += 1;
        }
        return i+1;
    }
};
