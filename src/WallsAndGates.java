import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0) return;
        int n = rooms[0].length;
        if(n == 0) return;
        Queue<Long> queue = new LinkedList<Long>();
        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(rooms[i][j] == 0){
                    queue.offer((long)i * n + (long)j);
                }
            }
        }
        while(!queue.isEmpty()){
            Long top = queue.poll();
            int y = (int) (top / n);
            int x = (int) (top % n);
            if(y > 0){// up
                if(rooms[y-1][x] > rooms[y][x] + 1){
                    rooms[y-1][x] = rooms[y][x] + 1;
                    queue.offer((long)(y-1) * n + (long)x);
                }
            }
            if(y < m - 1){// down
                if(rooms[y+1][x] > rooms[y][x] + 1){
                    rooms[y+1][x] = rooms[y][x] + 1;
                    queue.offer((long)(y+1) * n + (long)x);
                }
            }
            if(x > 0){//left
                if(rooms[y][x-1] > rooms[y][x] + 1){
                    rooms[y][x-1] = rooms[y][x] + 1;
                    queue.offer((long)y * n + x - 1);
                }
            }
            if(x < n - 1){// right
                if(rooms[y][x+1] > rooms[y][x] + 1){
                    rooms[y][x+1] = rooms[y][x] + 1;
                    queue.offer((long)y * n + x + 1);
                }
            }
        }
    }
}
