class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int slow = -1;
        int fast = 0;
        int n = nums.size();
        while(fast < n){
            if(nums[fast] != val){
                slow += 1;
                nums[slow] = nums[fast];
            }
            fast += 1;
        }
        return slow + 1;
    }
};
