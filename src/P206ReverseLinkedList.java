public class P206ReverseLinkedList {
    ListNode newHead = null;//倒转后对链表头进行初始化

    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode newTail = reverse(head);
        newTail.next = null;//将原头节点指向空 变为reverse后的尾jiedian
        return newHead;
    }

    public ListNode reverse(ListNode node) {
    //不断调用自身函数的结束条件：当当前节点的next为空，则当前节点就是未倒转链表的最后一个节点，也就是倒转节点的第一个节点
        if (node.next == null) {
            newHead = node;//全局变量。 这一句是为了记录头节点方便上面函数使用
            return node;//这里的node指的是原连标里的Tail节点，也就是reverse后链表的head，所以上一步记录下头节点
        }
        ListNode newTail = reverse(node.next);//不断调用自身函数从而遍历节点
        newTail.next = node;// 改变指针方向，使node.next的指针指向node本身，起到反转左右
        return node;//这里的node针对于原链表除Tail以外的节点，也就是reverse后head以后的节点
    }
}
/*
        P206ReverseLinkedList p206=new P206ReverseLinkedList();
        ListNode res=p206.reverseList(new ListNode(new int[]{1,2,3,4,5}));
        res.printListNode();
*/
