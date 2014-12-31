/**
 * User: guoxc
 * Date: 14-10-9
 * Time: 15:45
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int al = A.length;
        int x = 0;

        for(int i = 0; i < al; i += 1){
            x = x^A[i];
        }
        return x;
    }

    public static void test() {
        SingleNumber sn = new SingleNumber();
        int[] testL = new int[] {1,2,3,4,5,6,7,6,2,1,4,5,7};
        System.out.println(3 == sn.singleNumber(testL));
    }
}
