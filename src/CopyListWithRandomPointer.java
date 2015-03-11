import java.util.HashMap;

/**
 * User: guoxc
 * Date: 15-3-11
 * Time: 16:03
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> oldToNew = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        if(p == null){
            return null;
        }else{
            oldToNew.put(head, new RandomListNode(p.label));
        }
        while(p != null) {
            RandomListNode t = oldToNew.get(p);
            if(p.random != null) {
                if (oldToNew.containsKey(p.random)) {
                    t.random = oldToNew.get(p.random);
                } else {
                    oldToNew.put(p.random, new RandomListNode(p.random.label));
                    t.random = oldToNew.get(p.random);
                }
            }
            if(p.next != null) {
                if (oldToNew.containsKey(p.next)) {
                    t.next = oldToNew.get(p.next);
                } else {
                    oldToNew.put(p.next, new RandomListNode(p.next.label));
                    t.next = oldToNew.get(p.next);
                }
            }
            p = p.next;
        }
        return oldToNew.get(head);
    }
}
