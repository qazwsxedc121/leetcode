/**
 * User: guoxc
 * Date: 15-8-18
 * Time: 22:37
 */
public class AddDigits {
    public int addDigits(int num) {
        if(num < 10) return num;
        int x = 0;
        while(num > 0){
            x += num % 10;
            num = num / 10;
        }
        return addDigits(x);
    }
}
