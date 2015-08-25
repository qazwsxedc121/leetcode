/**
 * User: guoxc
 * Date: 15-8-25
 * Time: 10:02
 */
public class ReverseWordsInAStringII {
    private void swap(char[] s, int l, int r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
    private void reverse(char[] s, int l, int r){
        int mid = (l + r + 1) / 2;
        for(int i = l; i < mid; i += 1){
            swap(s, i, r - i + l);
        }
    }
    private void rotate(char[] s, int c, int r){
        //c == rotate how many chars to right, c >= 1
        reverse(s, 0, r);
        reverse(s, 0, r - c);
        reverse(s, r - c + 1, r);
    }
    public void reverseWords(char[] s) {
        int n = s.length;
        int i = 0;
        int r = n - 1;
        while(true){
            while( i < r && s[i] != ' '){
                i += 1;
            }
            if(i < r){
                rotate(s, i, r);//move word to end
                r -= i;

                //move the space
                for(int j = 0; j < r; j += 1){
                    s[j] = s[j+1];
                }
                s[r] = ' ';
                r -= 1;
                i = 0;
            }else{
                break;
            }
        }
        return;
    }
}
