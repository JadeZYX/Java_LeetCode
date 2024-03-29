
public class P0019RemoveNthNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        for(int i=0;i<n;i++){//fast先走N步，使快慢指针距离差N
            fast=fast.next;
        }
        while(fast.next!=null){//此时fast在链表尾部
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);//因为头节点也可能会被remove掉，所以必须开出来一个空间
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
    //fast走到终点，它的下一个才是null。不能写成fast==null 这时slow正好落在需要删除的节点上，已经够不到slow的前一个节点
        int count = 0;//若count= 1，则小于等于N
        while(fast.next != null){
            while(count < n){
                fast=fast.next;
                count++;
            }
            if(fast.next!=null){//当链表就只有一个节点，且需要删除一个节点的时候，如果不加if语句，fast的next就已经是null了。则while循环next会抛异常，因此必须加if判定，所以上面的解法更好。让fast先走，然后再写while循环
                fast=fast.next;
                slow = slow.next;
            }
        }
       slow.next = slow.next.next;
       return dummy.next;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {//straightforward方法
        if(head == null) return null;
        if(head.next == null && n ==1) return null;
        int count = 1;
        ListNode p = head;
        //size of the list
        while(p.next != null){
            count++;
            p = p.next;
        }
        //如果长度为4，要删除倒数第四个，也就是删除第一个，所以返回head.next
        if(count == n) {
            head = head.next;
            return head;
        }
        ListNode prev= head;
        //count - n 是要删除节点的前一个
        for(int i = 1;i<count-n;i++){
    //因为此时prev已经在头节点上了，所以是1，当取到count-n的时候，prev=prev.next就到了删除节点，所以要在它之前就停止loop
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

}
/*
这里快慢指针的距离始终是n,所以当fast走到尾部，slow指针的位置与结尾正好差了n个，也就是它的下一个就是要删除的节点。
这里不能返回head而返回dummy.next的原因是，原来的head也许会被remove掉
P0019RemoveNthNodeFromEndOfLinkedList p19 = new P0019RemoveNthNodeFromEndOfLinkedList();
System.out.println(p19.removeNthFromEnd1(new ListNode(new int[]{1}), 1));
 */