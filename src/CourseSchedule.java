import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: guoxc
 * Date: 15-5-7
 * Time: 16:34
 */
public class CourseSchedule {
    public int visited[];
    public List<List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        graph = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < numCourses; i += 1){
            graph.add(new ArrayList<Integer>());
            set.add(i);
        }

        for(int i = 0; i < prerequisites.length; i += 1){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            if(set.contains(prerequisites[i][0])){
                set.remove(prerequisites[i][0]);
            }
        }
        for(Integer i : set){
            boolean f = visit(i);
            if(!f) return false;
        }
        for(int i = 0; i < visited.length; i += 1){
            if(visited[i] != 2) return false;
        }
        return true;
    }
    private boolean visit(int n){
        if(visited[n] == 1){
            return false;
        }
        visited[n] = 1;
        for(Integer i : graph.get(n)){
            boolean f = visit(i);
            if(!f){
                return false;
            }
        }
        visited[n] = 2;
        return true;
    }
    public static void test(){
        CourseSchedule c = new CourseSchedule();
        System.out.println(c.canFinish(3, new int[][]{{2,0},{2,1}}));
    }
}
