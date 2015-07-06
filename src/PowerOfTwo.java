/**
 * User: guoxc
 * Date: 15-7-6
 * Time: 22:53
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        int z = 1;
        int i = 1;
        while(z != n && i < 32){
            z = 1 << i;
            i += 1;
        }
        if( i == 32){
            return false;
        }else{
            return true;
        }
    }
}
