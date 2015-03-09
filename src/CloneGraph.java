import java.util.*;

/**
 * User: guoxc
 * Date: 15-3-9
 * Time: 13:44
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        visited.put(node, res);
        q.add(node);
        while(!q.isEmpty()){
            UndirectedGraphNode top = q.poll();
            UndirectedGraphNode topClone = visited.get(top);
            for(int i = 0; i < top.neighbors.size(); i += 1){
                UndirectedGraphNode nodeI = top.neighbors.get(i);
                if(visited.containsKey(nodeI)){
                    topClone.neighbors.add(visited.get(nodeI));
                }else{
                    q.add(nodeI);
                    UndirectedGraphNode newNode = new UndirectedGraphNode(nodeI.label);
                    visited.put(nodeI, newNode);
                    topClone.neighbors.add(newNode);
                }
            }
        }
        return res;
    }
}
