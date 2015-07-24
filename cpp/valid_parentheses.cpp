class Solution {
public:
    bool isValid(string s) {
        int n = s.length();
        stack<char> st;
        for(int i = 0; i < n; i += 1){
            char c = s[i];
            switch (c){
            case '(':
            case '{':
            case '[':
                st.push(c);
                break;
            case ')':
                if(!st.empty() && st.top() == '('){
                    st.pop();
                }else{
                    return false;
                }
                break;
            case '}':
                if(!st.empty() && st.top() == '{'){
                    st.pop();
                }else{
                    return false;
                }
                break;
            case ']':
                if(!st.empty() && st.top() == '['){
                    st.pop();
                }else{
                    return false;
                }
                break;
            default:
                return false;
            }
        }
        return st.empty();
    }
};
