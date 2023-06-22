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
        return node;//这里的node针对于原链表除Tail以外的节点，也就是reverse后head以后的节点,把当前“头”节点返回给上一层
    }

    /*
     * Iteration解法
1把当前节点的下一个节点存下来 2 更改当前节点的指针方向，让它指向新头节点 3更新新头节点 4更新当前节点变成之前存下来的下一个节点，从而进行下一轮循环
     */
    public ListNode reverseList1(ListNode head){
        //corner case
        if(head == null)return null;
        ListNode newHead = null;
        while(head !=null){
            ListNode next = head.next;
            //change the point
            head.next = newHead;
            //set the current head as newHead
            newHead = head;
            //update current head to next node to continue iteration
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head){
        //Base Case -> Last Node a:return itself(no need to reverse a single node list)
        if(head == null || head.next == null){//仅头节点为空 + 递归的终止
            return head;
        }
        //Reverse everything after current node 递归题目从中间状态思考：假设当前节点是2
        ListNode reversed = reverseList2(head.next);//1->2->reversed
        //Reverse current node
        head.next.next = head;//reverse connection 也就是reversed.next指向2
        head.next = null;//cut off current connection即 2.next->null
        return reversed;//return reversed head
    }
}
/*
本题目是reverse 原链表，而不是复制或者重新创建一个不一样的地址的新链表，也就是要原地修改
        P206ReverseLinkedList p206=new P206ReverseLinkedList();
        ListNode res=p206.reverseList(new ListNode(new int[]{1,2,3,4,5}));
        res.printListNode();
*/
