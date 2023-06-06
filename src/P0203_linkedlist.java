
public class P0203_linkedlist {
    public ListNode removeElements(ListNode head,int val){
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);//为方便处理头节点开出一个虚拟节点和对应的指针，并让虚拟节点和head相连
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }
            else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
    public ListNode removeElements1(ListNode head,int val){
        while(head!=null&&head.val==val){
            head=head.next;//处理头节点和要删除的值一致的情况。如果整个list都要删除，最后的next指向null
        }

        if (head == null) {//上一步是看头节点是否需要删除
            return null;
        }

        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }
            else{
                cur=cur.next;
            }
        }
        return head;
    }
}
/*
P0203_linkedlist p203=new P0203_linkedlist();
ListNode result=p203.removeElements1(new ListNode(new int[]{7,7,7,7,7}),7);
ListNode result1=p203.removeElements(new ListNode(new int[]{1,2,6,3,5,6}),6);
if (result != null) {
    result.printListNode();//调用void类型的函数 无返回值，也没有参数
}

result1.printListNode();
*/