import java.util.*;

/**
 * Created by Administrator on 2015/5/14.
 */
public class CourseScheduleII {
    private List<List<Integer>> graph = new ArrayList<List<Integer>>();
    private Set<Integer> start = new HashSet<>();
    private int n;
    private int[] res;
    private int res_i;
    private int[] visited;
    private boolean flag = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        res = new int[n];
        visited = new int[n];
        for(int i = 0; i < n; i += 1){
            graph.add(new ArrayList<Integer>());
            start.add(i);
        }
        for(int i = 0; i < prerequisites.length; i += 1){
            if(start.contains(prerequisites[i][1])){
                start.remove(prerequisites[i][1]);
            }
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        res_i = 0;
        for(Integer s : start){
            search(s);
        }
        if(flag && res_i == n){
            return res;
        }else {
            return new int[]{};
        }
    }
    private void search(int v){
        visited[v] = 1;
        for(Integer k : graph.get(v)){
            if(visited[k] == 0){
                search(k);
            }else if(visited[k] == 1){
                flag = false;
            }
        }
        visited[v] = 2;
        res[res_i] = v;
        res_i += 1;
    }
    public static void test(){
        CourseScheduleII c = new CourseScheduleII();
        System.out.println(Arrays.toString(c.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }
}
