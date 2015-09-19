import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/19.
 */
public class ZigzagIterator {
    LinkedList<Integer> arr;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        arr = new LinkedList<Integer>();
        int i1 = 0;
        int i2 = 0;
        int n1 = v1.size();
        int n2 = v2.size();
        while(i1 < n1 && i2 < n2){
            arr.add(v1.get(i1));
            arr.add(v2.get(i2));
            i1 += 1;
            i2 += 1;
        }
        if(i1 < n1){
            for(int i = i1; i < n1; i += 1){
                arr.add(v1.get(i));
            }
        }else if(i2 < n2){
            for(int i = i2; i < n2; i += 1){
                arr.add(v2.get(i));
            }
        }
    }

    public int next() {
        return arr.poll();
    }

    public boolean hasNext() {
        return arr.size() > 0;
    }
}
