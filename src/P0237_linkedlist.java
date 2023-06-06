public class P0237_linkedlist {
    public void deletNode(ListNode node){
        node.val=node.next.val;//因为不是尾节点，题目中给出条件是有效节点且不重复，所以可以直接把要删除节点的值换成其下一个节点的值
        node.next=node.next.next;
    }
}
/*
      P0237_linkedlist p237=new P0237_linkedlist();
      ListNode head=new ListNode(new int[]{1,2,3,4,5});
       p237.deletNode(head.next.next);
       head.printListNode();//调用
*/
//区别于83题。83给出了head，所以删除是利用指针来删除，就是前面的指针直接跳过要删除的节点指向它的next.next
//237题，题目没有给出head，只给出了某个要删除的节点，所以不能利用指针从head开始找要删除的。可以直接在节点替换
//的方法，就是把要删除的节点的值用它的next.val给换下来，这时候就有两个next.val,所以把要删除节点的指针直接指向next.next
