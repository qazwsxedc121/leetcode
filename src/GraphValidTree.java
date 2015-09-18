import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tureoyz on 15-9-18.
 */
public class GraphValidTree {
    int[] visited;
    Map<Integer, Set<Integer>> g;
    private boolean dfs(int root, int from){
        if(visited[root] == 1) return false;
        visited[root] = 1;
        Set<Integer> next = g.get(root);
        for(Integer k : next){
            if(k == from) continue;
            if(!dfs(k, root)) return false;
        }
        visited[root] = 2;
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        visited = new int[n];
        g = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < edges.length; i += 1){
            if(edges[i][0] == edges[i][1]) return false;
            if(!g.containsKey(edges[i][0])){
                g.put(edges[i][0], new HashSet<Integer>());
            }
            if(!g.containsKey(edges[i][1])){
                g.put(edges[i][1], new HashSet<Integer>());
            }
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        if(n == 0) return false;
        if(edges.length == 0) return edges.length == n - 1;
        if(!dfs(0, 0)) return false;
        return edges.length == n - 1;
    }
}
