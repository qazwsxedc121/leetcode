class Solution {
private:
    bool eq(map<string, int>& m1, map<string, int>& m2){
        for(map<string, int>::iterator it = m1.begin(); it != m1.end(); ++it){
            if(m2[it->first] != it->second){
                return false;
            }
        }
        return true;
    }
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int n = words.size();
        int wl = words[0].length();
        map<string,int> histogram0;
        for(int i = 0; i < n; i += 1){
            histogram0[words[i]] += 1;
        }
        vector<int> res;
        int sn = s.length();
        for(int i = 0; i < sn - (wl * n) + 1; i += 1){
            map<string, int> histogram1;
            bool flag = false;
            for(int j = i; j < i + (wl * n); j += wl){
                string word = s.substr(j, wl);
                histogram1[word] += 1;
                if(histogram1[word] > histogram0[word]){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            if(eq(histogram0, histogram1)){
                res.push_back(i);
            }
        }
        return res;

    }
};
