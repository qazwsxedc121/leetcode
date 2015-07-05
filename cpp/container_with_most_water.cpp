class Solution {
public:
    int max(int a, int b){
        return a > b ? a : b;
    }
    int min(int a, int b){
        return a < b ? a : b;
    }
    int maxArea(vector<int>& height) {
        int n = height.size();
        int l = 0;
        int r = n - 1;
        int max_now = min(height[l], height[r]) * (n - 1);
        while(l < r){
            if(height[l] < height[r]){
                l += 1;
            }else{
                r -= 1;
            }
            int area = min(height[l], height[r]) * (r - l);
            if(area > max_now) {
                max_now = area;
            }
            
        }
        return max_now;
    }
};