public class P0024SwapNodesInParisLinkedList {
    public ListNode swapPairs0(ListNode head){
        if(head==null)return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null&&cur.next.next!=null){
            ListNode next1 = cur.next;
            ListNode next2 = cur.next.next;
            ListNode next3 = cur.next.next.next;
            next2.next = next1;
            next1.next = next3;
            cur.next = next2;
            cur = next1;
        }
        return dummy.next;
    }
    public ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode first=head,last=head.next;
        first.next=swapPairs(last.next);
        last.next=first;
        return last;
    }
}
