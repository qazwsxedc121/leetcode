//solution from http://tech-wonderland.net/blog/summary-of-ksum-problems.html

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> vecResult;
		if(nums.size() < 3)
			return vecResult;

		vector<int> vecTriple(3, 0);
		sort(nums.begin(), nums.end());
		int iCurrentValue = nums[0];
		int iCount = nums.size() - 2; // (1) trick 1
		for(int i = 0; i < iCount; ++i) {
			if(i && nums[i] == iCurrentValue) {
				continue;
			}
			// do 2 sum
			vecTriple[0] = nums[i];
			int j = i + 1;
			int k = nums.size() - 1;
			while(j < k) {
				int iSum = nums[j] + nums[k];
				if(iSum + vecTriple[0] == 0) {
					vecTriple[1] = nums[j];
					vecTriple[2] = nums[k];
					if(vecResult.size() == 0 || vecResult[vecResult.size() - 1] != vecTriple)
					    vecResult.push_back(vecTriple); // copy constructor
					++j;
					--k;
				}
				else if(iSum + vecTriple[0] < 0)
					++j;
				else
					--k;
			}
			iCurrentValue = nums[i];
		}

		return vecResult;
    }
};
