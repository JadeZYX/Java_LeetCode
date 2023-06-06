import java.util.HashMap;

public class P0138CopyListWithRandomPointer {
    HashMap<ListNode, ListNode> map = new HashMap<>();//hashmap存储原list和copy list。防止random再重复创建节点
    public ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;
        if (map.containsKey(head)) {//若hashmap里有此节点，直接取出来用那个节点
            return map.get(head);
        }
        ListNode newNode = new ListNode(head.val);
        map.put(head, newNode);//若hashmap里没有random指针指向的节点，则创建，且存到map里
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
    public ListNode copyRandomList1(ListNode head){
        if(head==null)return null;
        HashMap<ListNode,ListNode>listMap=new HashMap<>();
        //loop1 copy all the nodes, just value
        ListNode cur=head;
        while(cur!=null){
            listMap.put(cur, new ListNode(cur.val));//因为Node里包含value，还有next指针及random指针
            cur=cur.next;    //此时copy到map里到只是Node的value值，将它的next和random指针都初始化为null
        }
        //loop2 assign next and random pointers
        cur=head;
        while(cur!=null){
            listMap.get(cur).next=listMap.get(cur.next);
            listMap.get(cur).random=listMap.get(cur.random);
            cur=cur.next;
        }
        return listMap.get(head);
    }
}
/*
       P0138CopyListWithRandomPointer s = new P0138CopyListWithRandomPointer();
       ListNode oldHead = new ListNode(new int[]{1,2,3});
       ListNode newHead = s.copyRandomList(oldHead);
       newHead.printListNode();
*/
