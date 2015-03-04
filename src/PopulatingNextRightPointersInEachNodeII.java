/**
 * Created by Administrator on 2015/3/4.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            return;
        }else if(root.left == null){
            connect(root.right);
            return;
        }else if(root.right == null){
            connect(root.left);
            return;
        }else{
            connect(root.left);
            connect(root.right);
            TreeLinkNode pl0 = root.left;
            TreeLinkNode pl1 = root.left;
            TreeLinkNode pr = root.right;
            while (pl0 != null){
                TreeLinkNode nextpl1 = rightMost(pl0);
                pl0 = leftMost(pl0);
                pl1.next = pr;
                pl1 = nextpl1;
                pr = leftMost(pr);
            }
            return;
        }
    }
    private TreeLinkNode leftMost(TreeLinkNode lastLeft){
        while (lastLeft != null) {
            if (lastLeft.left != null){
                return lastLeft.left;
            }else if(lastLeft.right != null){
                return lastLeft.right;
            }
            lastLeft = lastLeft.next;
        }
        return null;
    }
    private TreeLinkNode rightMost(TreeLinkNode lastLeft){
        TreeLinkNode res = null;
        while(lastLeft != null){
            if(lastLeft.right != null){
                res = lastLeft.right;
            }else if(lastLeft.left != null){
                res = lastLeft.left;
            }
            lastLeft = lastLeft.next;
        }
        return res;
    }
    public static void test(){
        TreeLinkNode t0 = new TreeLinkNode(0);
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        t0.left = t1;
        t0.right = t2;
        t2.left = t3;
        t2.right = t4;
        PopulatingNextRightPointersInEachNodeII p = new PopulatingNextRightPointersInEachNodeII();
        p.connect(t0);
        return;
    }
}
