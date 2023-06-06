public class P0082_linkedlist {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head; //不同于更改引用节点，用于前后节点的连接
        ListNode pre=dummy;//跟踪不重复元素
        ListNode cur=head;//跟踪重复元素
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){//只有cur.next存在才能比较cur和cur.next的值。节点可以指向空，但是比较值的时候不能是空，否则报错
                cur=cur.next;//更改引用节点
            }
            if(pre.next==cur){  //这里的==指在同一个节点上，而不是二者的值一样,所以其实等号左右的两个节点在同一个节点上
                pre=pre.next;
            }
            else if(pre.next!=cur){//若pre节点和cur节点不相邻
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}
/*
       P0082_linkedlist p82=new P0082_linkedlist();
       ListNode result=p82.deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5}));
        ListNode res=p82.deleteDuplicates(new ListNode(new int[]{1,1}));
       result.printListNode();
        if(res!=null){
            res.printListNode();
        }
*/
