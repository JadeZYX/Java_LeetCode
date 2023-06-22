public class P0141LinkedListCycle {
    public boolean hasCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            ///要先让快慢指针动起来，在看是否相遇，因为起点是同一位置
            //如果上来就写if语句，而非先动快慢指针，则在同一个位置上的快慢指针会直接跳出循环
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next==null)return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){//如果fast.next是null了，则fast.next.next 就会报错
            if(slow == fast){
                return true;
            }
            slow =slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
/*
 如何思考while循环的condition？ 如果是个环，则不存在end，则一旦快慢指针到达一样位置则说明有环。若不是个环就会有end节点，则就要考虑节点不为null的情况
 P141题是要找出在哪个位置相遇，是这道题目的进阶版
 */