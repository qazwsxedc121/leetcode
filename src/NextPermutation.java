import java.util.Arrays;

/**
 * User: guoxc
 * Date: 15-1-17
 * Time: 14:05
 */
public class NextPermutation {
    public void nextPermutation(int[] num){
        int j = -1;
        for(int i = num.length-2; i > -1; i -= 1){
            if(num[i] < num[i+1]){
                j = i;
                break;
            }
        }
        if(j == -1){
            reverse(num, 0, num.length);
            return;
        }
        int min = num[j+1];
        int k = j + 1;
        for(int i = j + 1; i < num.length; i += 1){
            if(num[i] > num[j] && num[i] <= min){
                min = num[i];
                k = i;
            }
        }
        swap(num, j, k);
        reverse(num, j + 1, num.length);
        return;

    }
    public void swap(int[] num, int i, int j){
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }
    public void reverse(int[] num, int i, int j){
        int l = j - i;
        if(l < 2) return;
        for(int k = i; k < l / 2 + i; k += 1){
            swap(num, k, j - 1 - k + i);
        }
        return;
    }
    public static void test(){
        NextPermutation instance = new NextPermutation();
        int[] x1 = new int[]{2,3,1,3,3};
        instance.nextPermutation(x1);
        System.out.println(Arrays.toString(x1));
        int[] x2 = new int[]{3,2,1};
        instance.nextPermutation(x2);
        System.out.println(Arrays.toString(x2));
        int[] x3 = new int[]{1,1,5};
        instance.nextPermutation(x3);
        System.out.println(Arrays.toString(x3));
    }
}
