class Solution {
private:
    int same(string s, int start,  string p, int p_len){
        for(int i = 0; i < p_len; i += 1){
            if(s[start + i] != p[i]){
                return 0;
            }
        }
        return 1;
    }
public:
 int strStr(string haystack, string needle) {
    int len1 = haystack.size();
    int len2 = needle.size();
     int next[26], i, j;
     for (i = 0; i<26; i++){
         next[i] = len2 + 1;
     }
     for (i = 0; i<len2; i++){
         next[needle[i] - 'a'] = len2 - i;
     }
     int result = -1;
     int times;
     int pos = 0;
     while (len1-pos >= len2){
         if (haystack.substr(pos,len2) == needle)
         {
             result = pos;
             break;
         }
         else {
             times = next[haystack[pos+len2] - 'a'];
             pos += times;
         }
     }
     return result;
    }
};
