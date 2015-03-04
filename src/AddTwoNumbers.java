public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode n3 = new ListNode(0);
        ListNode r = n3;
        int c = 0;
        while((n1 != null) && (n2 != null)){
            n3.next = new ListNode(0);
            n3 = n3.next;
            int[] addres = add(n1.val, n2.val, c);
            n3.val = addres[0];
            c = addres[1];
            n1 = n1.next;
            n2 = n2.next;
        }
        if(n2 != null){
            n1 = n2;
        }
        while(n1 != null){
            n3.next = new ListNode(0);
            n3 = n3.next;
            int[] addres = add(n1.val, 0, c);
            n3.val = addres[0];
            c = addres[1];
            n1 = n1.next;
        }
        if(c == 1){
            n3.next = new ListNode(1);
        }

        return r.next;
    }
    public int[] add(int d1, int d2, int c){
        int[] res = new int[]{0,0};
        if (d1 + d2 + c > 9){
            res[0] = d1 + d2 + c - 10;
            res[1] = 1;
        }else{
            res[0] = d1 + d2 + c;
            res[1] = 0;
        }
        return res;
    }
}