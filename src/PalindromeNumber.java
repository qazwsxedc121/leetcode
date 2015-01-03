/**
 * User: guoxc
 * Date: 15-1-3
 * Time: 4:19
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x){
        int k;
        if (x < 0){
            return false;
        }
        while(x > 9) {
            k = 1;
            while (x > k && k != 1000000000) {
                k = k * 10;
            }
            if(k != 1000000000) k = k / 10;
            // get k     x = 323 -> k = 100
            if (x / k == x % 10) {
                x -= k * (x % 10) + x % 10;
                if(x < k / 10 && k >= 1000) x += k / 10 + 10;
                x = x / 10;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void test(){
        System.out.println(new PalindromeNumber().isPalindrome(10021));
        System.out.println(new PalindromeNumber().isPalindrome(1874994781));
        System.out.println(new PalindromeNumber().isPalindrome(1041));
    }
}
