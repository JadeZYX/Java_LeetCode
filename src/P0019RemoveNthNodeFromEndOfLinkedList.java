
public class P0019RemoveNthNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        for(int i=0;i<n;i++){//fast先走N步，使快慢指针距离差N
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}//这里快慢指针的距离始终是n,所以当fast走到尾部，slow指针的位置与结尾正好差了n个，也就是它的下一个就是要删除的节点。
//这里不能返回head而返回dummy.next的原因是，原来的head也许会被remove掉