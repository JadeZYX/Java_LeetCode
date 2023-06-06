public class P0083_ListNode {
    public ListNode deleteDuplicates(ListNode head) {
       if(head==null){
           return null;
       }
       ListNode p=head;
       while(p.next!=null){
           if(p.val==p.next.val){
               p.next=p.next.next;//跳过p.next,指针p直接指向p.next.next
           }      
           else{
               p=p.next;
           }
       }
       return head;   
    }
}
//若是 1 1 1 2 2 3  或者1 1 2 2 3 3 3 或1 1 1 1 1 
/*
        P0083_ListNode p0083=new P0083_ListNode();
        ListNode result=p0083.deleteDuplicates(new ListNode(new int[]{1,1,1,2,3,3}));
        result.printListNode();
*/