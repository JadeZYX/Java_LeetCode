public class P0143ReorderList {
  public void reorderList(ListNode head) {
    // 如果节点只有一个
    if (head == null || head.next == null) {
      return;
    }
    // 如果节点只有两个
    // 找到middle node 这样把整个linked list截取成两段
    ListNode middleNode = findMiddleNode(head);
    ListNode middleNextNode = middleNode.next;// 存储中间节点的下一个节点
    ListNode p = head;// 遍历链表，当p到了middle 节点，将p的下一个指向null，断开与middle下一个节点的connection
    while (p != middleNode) {
      p = p.next;
    }
    p.next = null;// 截取出前部分的尾巴节点指向null
    ListNode l1 = head;
    ListNode l2 = middleNextNode;
    // 将第二部分的链表 reverse 一下
    ListNode reversedL2 = reverseRecursion(l2);
    // ListNode reversedL2 = reverseIteration(l2);
    // 重组两部分链表 返回的是void 所以不能create 新链表
    ListNode p1 = l1;
    ListNode p2 = reversedL2;
    while (p1 != null && p2 != null) {
      ListNode p1Next = p1.next;
      ListNode p2Next = p2.next;
      p1.next = p2;
      p2.next = p1Next;
      p1 = p1Next;
      p2 = p2Next;
    }
  }

  public ListNode findMiddleNode(ListNode node) {
    // 设置快慢指针，快指针每次两步，慢指针每次一步，当快指针走到头时候，慢指针就处在中间位置
    ListNode slow = node;
    ListNode fast = node;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode reverseRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode reversed = reverseRecursion(head.next);
    head.next.next = head;// reversed.next = head;
    head.next = null;
    return reversed;//return head
  }

  public ListNode reverseIteration(ListNode head) {
    if (head == null)
      return head;
    ListNode res = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = res;
      res = head;
      head = next;
    }
    return res;
  }
}
/*
        P0143ReorderList p143 = new P0143ReorderList();
        p143.reorderList(new ListNode(new int[]{1,2,3,4,5}));
      void返回类型，所以直接调用即可
     input: 1->2->3->4->5->6->7->8->9 output: 1->9->2->8->3->7->4->6->5 第一段是1，2，3，4，5，第二段是6，7，  8，9，但从输出可以看出，顺序变成了9，8，7，6，所以要把第二段反转下
     当slow走到5，fast正好走到9，所以中点是5
     input： 1->2->3->4->5->6 output:
     当slow走到3，fast走到5，但fast.next.next为null，所以退出循环，中间值是slow 3.
     如果链表本身是双数，则两段链表一样长，如果链表是单数，则中点会落在第一段，且第一段比第二段多一个node

*/
