import java.util.Arrays;

/**
 * User: guoxc
 * Date: 14-10-9
 * Time: 17:39
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] sorted = new int[numbers.length];
        for(int i = 0; i < numbers.length; i += 1){
            sorted[i] = numbers[i];
        }
        Arrays.sort(sorted);
        int r1,r2;
        r1 = 0;
        r2 = sorted.length - 1;
        while (r1 < r2){
            int temp = sorted[r1] + sorted[r2];
            if(temp < target){
                r1 += 1;
            }else if(temp > target){
                r2 -= 1;
            }else{
                break;
            }
        }
        int s1 = sorted[r1];
        int s2 = sorted[r2];
        int x1 = 0;
        int x2 = 0;
        int s = 0;
        for(int i = 0; i < numbers.length; i += 1){
            if((numbers[i] == s1 || numbers[i] == s2) && s == 0){
                x1 = i;
                if(numbers[i] == s1){
                    s = 1;
                }else if(numbers[i] == s2){
                    s = 2;
                }
            }
            if(numbers[i] == s1 && s == 2){
                x2 = i;
            }
            if(numbers[i] == s2 && s == 1){
                x2 = i;
            }

        }



        return new int[]{x1+1,x2+1};

    }
    public static void test(){
        TwoSum ts = new TwoSum();

        int[] x = new int[]{2,1,9,4,4,56,90,3};
        int[] r1 = ts.twoSum(x, 8);
        Test.pt(r1[0] == 4 && r1[1] == 5);

        int[] x2 = new int[]{2,7,11,15};
        int[] r2 = ts.twoSum(x2,9);
        Test.pt(r2[0] == 1 && r2[1] == 2);
    }
}
