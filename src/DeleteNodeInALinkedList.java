/**
 * User: guoxc
 * Date: 15-7-15
 * Time: 22:22
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if(node.next == null){
            node = null;
        }else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
