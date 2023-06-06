public class P1721SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head,int k){
       ListNode fast=head;
       ListNode slow=head;
       ListNode swap1=null;
       ListNode swap2=null;
       for(int i=1;i<k-1;i++){//fast指针的当前位置就是从前面数第N个的位置
           fast=fast.next;
       }
       swap1=fast;//第一个需要交换的节点
       while(fast.next!=null){
           slow=slow.next;
           fast=fast.next;
       }
       swap2=slow;
       int temp=swap1.val;
       swap1.val=swap2.val;
       swap2.val=temp;
       return head;
    }
}
