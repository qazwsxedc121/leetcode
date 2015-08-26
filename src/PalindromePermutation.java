/**
 * User: guoxc
 * Date: 15-8-26
 * Time: 20:00
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] charmap = new int[256];
        int n = s.length();
        for(int i = 0; i < n; i += 1){
            charmap[s.charAt(i)] += 1;
        }
        int odds = 0;
        for(int i = 0; i < 256; i += 1){
            if(charmap[i] % 2 == 1) odds += 1;
        }
        return odds <= 1;
    }
}
