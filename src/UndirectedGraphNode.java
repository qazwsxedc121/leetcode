import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-3-9
 * Time: 13:43
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
