import java.util.PriorityQueue;

public class P0023MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {// T：O(n*(logK)) n是array长度 k是链表长度 S:O(n*k)
    if (lists == null || lists.length == 0)
      return null;
    ListNode dummy = new ListNode(-1);// create 新节点，值为-1
    ListNode curNode = dummy;// 用于遍历节点 go forward to next node
    PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));// 定义优先队列且按照从小到大的顺序排列，时间复杂度为o(logn)
    for (ListNode head : lists) {
      if (head != null) {// [[1,4,5],[1,3,4],[2,6,7],[]]可能元素为空链表
        queue.offer(head);// 把array里每个链表头节点添加到优先队列
      }
    }
    while (!queue.isEmpty()) {// queue.size()!=0
      ListNode popE = queue.remove();
      curNode.next = popE;
      curNode = curNode.next;// 移动到下一个
      if (popE.next != null) {
        queue.add(popE.next);
      }
    }
    return dummy.next;
  }
}
/*
 * array里面会有K条链表，所以不太能用two pointer，merge 2 sorted linked list的解法来做
 * 这道题目用priority queue来做，用for
 * loop把所有的K条链表的头节点添加到queue里。注意当下只能添加每条链表的头节点，够不到头节点后面的节点。然后把最小值poll出来，添加到结果链表里，
 * 同时移动到当前链表的下一个节点，继续出队列尾巴的节点
 */
