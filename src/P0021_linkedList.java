
class P0021_linkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { // 头节点
        ListNode dummy_head = new ListNode(0);// 开出头节点，针对于单链表没有前向指针，可以假设一个哑节点并赋值
        ListNode curr = dummy_head;// 定义当前指针指向哑节点即头节点
        if (l1 == null) { // corner case
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);//标准写法 开出一个新的节点并赋值
                l1 = l1.next;// 头给扔掉
            } else { 
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;// 更改指针方向
        }
        curr.next = l1 == null ? l2 : l1;// 把没有处理完的list粘贴
        return dummy_head.next;// 将dummy head去掉

    }
}
/*
        P0021_linkedlist p0021 = new P0021_linkedlist();
        ListNode l1 = new ListNode(new int[]{1,2,4});
        ListNode l2 = new ListNode(new int[]{1,3,4});
        ListNode result = p0021.mergeTwoLists(l1, l2);//声明定义新的节点来存储合并后的结果
        result.printListNode();//这里调用的ListNode类下的printListNode函数
*/
        //l1.next = new ListNode(2);
        //l1.next.next = new ListNode(4);
        //printListNode(result);//若在List Node class类外写print函数，则需要传入参数

// 两个list不断取较小的头元素，取完以后去掉，直到取完一个list，将另一个没有取完的list粘到结尾。
// dummy head->a->b->dummy tail
// 链表里节点的默认值int类型的是0.只是如果不定义新的指针，则不存在下一个节点了。节点一旦存在一定有值，但是不确定是否存在next