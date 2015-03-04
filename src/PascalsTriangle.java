import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/4.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0) return res;
        int i = 1;
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        res.add(last);
        i += 1;
        while(i <= numRows){

            List<Integer> newLine = new ArrayList<Integer>();
            newLine.add(1);
            for(int j = 1; j < last.size(); j += 1){
                newLine.add(last.get(j-1) + last.get(j));
            }
            newLine.add(1);
            res.add(newLine);
            last = newLine;
            i += 1;
        }
        return res;
    }
}
