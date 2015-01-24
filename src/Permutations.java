import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/1/24.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num){
        int[] indexes = new int[num.length];
        for(int i = 0; i < indexes.length; i += 1){
            indexes[i] = i;
        }
        boolean notEnd = true;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while(notEnd){
            List<Integer> toAdd = new ArrayList<Integer>();
            for(int i = 0; i < indexes.length; i += 1){
                toAdd.add(num[indexes[i]]);
            }
            res.add(toAdd);
            notEnd = nextPermute(indexes);
        }
        return res;
    }
    public boolean nextPermute(int[] num){
        int i = num.length - 1;
        while(i > 0 && num[i] < num[i - 1]){
            i -= 1;
        }
        if(i == 0) return false;
        // num[i] > num[i - 1]
        int p = i-1;
        int q = i;
        while(i < num.length){
            if(num[i] < num[q] && num[i] > num[p]){
                q = i;
            }
            i += 1;
        }
        // num[q] == min in num[p+1:end]

        swap(num,p,q);
        reverse(num,p+1,num.length);
        return true;
    }
    public void swap(int[] num, int p, int q){
        int temp = num[q];
        num[q] = num[p];
        num[p] = temp;
    }
    public void reverse(int[] num, int l, int r){
        if(l >= r) return;
        int mid = (l + r) / 2;
        for(int i = l; i < mid; i += 1){
            swap(num,i, r - (i - l) - 1);
        }
    }
    public static void test(){
        Permutations instance = new Permutations();
        System.out.println(instance.permute(new int[]{1,2,3,4,5}));
    }
}
