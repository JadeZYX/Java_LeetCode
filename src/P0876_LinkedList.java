public class P0876_LinkedList {
    public ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
//    P0876_LinkedList p876=new P0876_LinkedList();
    //    ListNode result=p876.middleNode(new ListNode(new int[]{1,2,3,4,5}));
    //    result.printListNode();
