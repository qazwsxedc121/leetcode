import java.util.List;

/**
 * Created by Administrator on 2015/9/4.
 */
public class Vector2D {

    private List<List<Integer>> store;
    private int x;
    private int y;
    private int m;

    public Vector2D(List<List<Integer>> vec2d) {
        y = 0;
        x = 0;
        m = vec2d.size();
        store = vec2d;
    }

    public int next() {
        while(y < m && x == store.get(y).size()){
            y += 1;
            x = 0;
        }
        if(y == m) return -1;//error
        List<Integer> l = store.get(y);
        int res = l.get(x);
        x += 1;
        while(y < m && x == store.get(y).size()){
            y += 1;
            x = 0;
        }
        return res;
    }

    public boolean hasNext() {
        while(y < m && x == store.get(y).size()){
            y += 1;
            x = 0;
        }
        if(y == m) return false;
        else return true;
    }
}
