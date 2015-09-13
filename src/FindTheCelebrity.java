import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/9/13.
 */
public class FindTheCelebrity {
    private boolean knows(int a, int b){
        return true;
    }
    public int findCelebrity(int n) {
        if(n == 0) return -1;
        if(n == 1) return 0;
        int now = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> maybe = new ArrayList<Integer>();
        stack.push(now);
        visited[now] = true;
        int vn = 0;
        while(vn < n){
            while(!stack.isEmpty()){
                now = stack.pop();
                vn += 1;
                boolean isMaybe = true;
                for(int i = 0; i < n; i += 1){
                    if(now == i) continue;
                    if(knows(now, i)){
                        isMaybe = false;
                        if(!visited[i]){
                            stack.push(i);
                            visited[i] = true;
                        }
                        break;
                    }
                }
                if(isMaybe){
                    maybe.add(now);
                }
            }
            if(vn < n){
                for(int i = 0; i < n; i += 1){
                    if(!visited[i]){
                        stack.push(i);
                        visited[i] = true;
                        break;
                    }
                }
            }
        }
        if(maybe.size() == 0) return -1;
        for(Integer k: maybe){
            boolean flag = false;
            for(int i = 0; i < n; i += 1){
                if(i == k) continue;
                if(!knows(i, k)){
                    flag = true;
                    break;
                }
            }
            if(!flag) return k;
        }
        return -1;
    }
}
