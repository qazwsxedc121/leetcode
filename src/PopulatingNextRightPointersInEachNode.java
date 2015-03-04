/**
 * Created by Administrator on 2015/3/4.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        connect(root.left);
        connect(root.right);
        TreeLinkNode pl = root.left;
        TreeLinkNode pr = root.right;
        while(pl != null && pr != null){
            pl.next = pr;
            pl = pl.right;
            pr = pr.left;
        }
        return;
    }
}
