class Solution {
public:
string longestPalindrome(string s) {
	int n = s.size();
	int res[] = {0,0};
	int maxl = 0;
	for(int i = 0; i <= 2 * (n - 1); i += 1){
		if(i % 2 == 0){
			int mid = i / 2;
			int l = mid;
			int r = mid;
			while(l >= 0 && r < n && s.at(l) == s.at(r)){
				l -= 1;
				r += 1;
			}
			l += 1;
			r -= 1;
			if(r - l + 1 > maxl){
				maxl = r - l + 1;
				res[0] = l;
				res[1] = r;
			}
		}else{
			int l = i / 2;
			int r = l + 1;
			if(s.at(l) != s.at(r)) continue;
			while(l >= 0 && r < n && s.at(l) == s.at(r)){
				l -= 1;
				r += 1;
			}
			l += 1;
			r -= 1;
			if(r - l + 1 > maxl){
				maxl = r - l + 1;
				res[0] = l;
				res[1] = r;
			}
		}
	}
	return s.substr(res[0],res[1] - res[0] + 1);
}
};